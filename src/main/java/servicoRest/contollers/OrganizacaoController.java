package servicoRest.contollers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import servicoRest.excpetion.NotFoundException;
import servicoRest.model.Local;
import servicoRest.model.Organizacao;
import servicoRest.repository.OrganizacaoRepository;

@RestController
public class OrganizacaoController {

	@Autowired
	private OrganizacaoRepository organizacaoRepository;

    @RequestMapping(value="/organizacao/{id}", method=RequestMethod.GET)
    public Organizacao getOrganizacao(@PathVariable long id) {
		return organizacaoRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    
    @RequestMapping(value="/organizacao/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateOrganizacao(@RequestBody Organizacao organizacao,@PathVariable long id) {
		Organizacao ong;
		try {
			ong = organizacaoRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Organizacao nao encontrada.", HttpStatus.NOT_FOUND);
		}

		ong.setNmCnpj(organizacao.getNmCnpj());
		ong.setRazaoSocial(organizacao.getRazaoSocial());
		ong.setNomeFantasia(organizacao.getNomeFantasia());
		ong.setEmail(organizacao.getEmail());
		ong.setDescricao(organizacao.getDescricao());
		ong.setSite(organizacao.getSite());
		ong.setFacebook(organizacao.getFacebook());
		ong.setInstagram(organizacao.getInstagram());
		
		organizacaoRepository.save(ong);
		return new ResponseEntity<Organizacao>(ong, HttpStatus.OK);
    }

    @RequestMapping(value="/organizacaoByEmail/{email}", method=RequestMethod.GET)
    public Organizacao getOrganizacaoByEmail(@PathVariable String email) {
		return organizacaoRepository.findByEmail(email).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/organizacao", method=RequestMethod.GET)
    public Iterable<Organizacao> getOrganizacao(
    		@RequestParam(value="id_endereco", required=false) String id_endereco) {
    	if(id_endereco != null) {
    		return organizacaoRepository.findByLocais_Endereco_IdEndereco(Long.parseLong(id_endereco));
    	} else {
    		return organizacaoRepository.findAll();
    	}
    }
    
    @RequestMapping(value="/organizacao", method=RequestMethod.POST)
    public ResponseEntity<Organizacao> createOrganizacao(@RequestBody Organizacao organizacao) {
    	Organizacao ong = organizacaoRepository.save(organizacao);
		return new ResponseEntity<Organizacao>(ong, HttpStatus.OK);

    }


	@RequestMapping(value = "/organizacao/{id}", method = RequestMethod.DELETE)
	public void deleteOrganizacao(@PathVariable long id) {
		organizacaoRepository.deleteById(id);
	}

}
