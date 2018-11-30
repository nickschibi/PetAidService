package servicoRest.contollers;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.model.Avaliacao;
import servicoRest.model.ContaBancaria;
import servicoRest.model.Local;
import servicoRest.model.Voluntariado;
import servicoRest.repository.AvaliacaoRepository;
import servicoRest.repository.ContaBancariaRepository;
import servicoRest.repository.EnderecoRepository;
import servicoRest.repository.LocalRepository;
import servicoRest.repository.VoluntariadoRepository;

@RestController
public class LocalController {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@Autowired
	private VoluntariadoRepository voluntariadoRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

    @RequestMapping(value="/local/{id}", method=RequestMethod.GET)
    public Local getLocal(@PathVariable long id) {
		return localRepository.findByIdLocal(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/local", method=RequestMethod.GET)
    public Iterable<Local> getLocal(@RequestParam(value="id_organizacao", required=false) String id_organizacao) {
    	if(id_organizacao == null) {
    		return localRepository.findAll();
    	} else {
    		return localRepository.findByOrganizacao_IdOrganizacao(Long.parseLong(id_organizacao));
    	}
    }

    @RequestMapping(value="/local", method=RequestMethod.POST)
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
    	Local l = localRepository.save(local);
		return new ResponseEntity<Local>(l, HttpStatus.OK);

    }
	

    @Transactional
    @RequestMapping(value="/local/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteLocal(@PathVariable long id, @RequestParam(value="force", required=false) String force) {
    	if(force != null && force.equals("true")) {
    		Iterable<ContaBancaria> contas = contaBancariaRepository.findByIdLocal((int)id);
    		for(ContaBancaria conta : contas) {
    			contaBancariaRepository.deleteById(conta.getIdConta());
    		}
    		Iterable<Avaliacao> avaliacoes = avaliacaoRepository.findByVoluntariado_idLocal((int)id);
    		for(Avaliacao avaliacao : avaliacoes) {
    			avaliacaoRepository.deleteById(avaliacao.getIdAvaliacao());
    		}
    		Iterable<Voluntariado> voluntariados = voluntariadoRepository.findByIdLocal(id);
    		for(Voluntariado voluntariado: voluntariados) {
    			voluntariadoRepository.deleteByIdVoluntariado(voluntariado.getIdVoluntariado());
    		}
    		
    		
    		Optional<Local> localOp = localRepository.findById(id);
    		Local local = localOp.orElse(null);
    		if(local != null) {
    			enderecoRepository.deleteById(local.getIdEndereco());
    		}
    		localRepository.deleteByIdLocal(id);
    	} else {
    		localRepository.deleteByIdLocal(id);
    	}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
   
    
    @RequestMapping(value = "/local/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLocal(@RequestBody Local local, @PathVariable long id) {

		Local l;
		try {
			l = localRepository.findByIdLocal(id).get();

		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Local nao encontrado.", HttpStatus.NOT_FOUND);
		}

		l.setNomeResponsavel(local.getNomeResponsavel());
		l.setTelefoneLocal(local.getTelefoneLocal());

		localRepository.save(l);
		return new ResponseEntity<Local>(l, HttpStatus.OK);
	}
	

}



