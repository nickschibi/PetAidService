package servicoRest.contollers;

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

    @RequestMapping(value="/organizacao", method=RequestMethod.GET)
    public Iterable<Organizacao> getOrganizacao(@RequestParam(value="id_endereco", required=false) String id_endereco) {
    	if(id_endereco == null) {
    		return organizacaoRepository.findAll();
    	} else {
    		return organizacaoRepository.findByLocais_Endereco_IdEndereco(Long.parseLong(id_endereco));
    	}
    }
    
    @RequestMapping(value="/organizacao", method=RequestMethod.POST)
    public ResponseEntity<Organizacao> createOrganizacao(@RequestBody Organizacao organizacao) {
    	Organizacao ong = organizacaoRepository.save(organizacao);
		return new ResponseEntity<Organizacao>(ong, HttpStatus.OK);

    }

}
