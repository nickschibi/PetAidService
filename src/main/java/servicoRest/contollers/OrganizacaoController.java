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
import servicoRest.repository.EnderecoRepository;
import servicoRest.repository.OrganizacaoRepository;
@RestController


public class OrganizacaoController {
	

	@Autowired
	private OrganizacaoRepository organizacaoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
		
		private static final String templateId = "Id [%d]";
		private static final String templateCNPJ = "CNPJ [%s]";
		private static final String templateRazaoSocial = "Razao Social [%s]";
		private static final String templateNomeFantasia = "Nome Fantasia [%s]";
		private static final String templateEmail = "Email [%s]";
		private static final String templateDescricao = "Descricao [%s]";
		private static final String templateSite = "Site [%s]";
		private static final String templateFacebook = "Facebook [%s]";
		private static final String templateInstagram = "Instagram [%s]";
	    

	    @RequestMapping(value="/organizacao/{id}", method=RequestMethod.GET)
	    public Organizacao getOrganizacao(@PathVariable long id) {
			return organizacaoRepository.findById(id).orElseThrow(NotFoundException::new);
	    }

	    @RequestMapping(value="/organizacao", method=RequestMethod.GET)
	    public Iterable<Organizacao> getOrganizacao(@RequestParam(value="id_endereco", required=false) String id_endereco) {
	    	if(id_endereco == null) {
	    		return organizacaoRepository.findAll();
	    	} else {
	    		//return organizacaoRepository.findByLocais_Id_IdEndereco(Long.parseLong(id_endereco));
	    		return null;
	    	}
	    }
	    
	    @RequestMapping(value="/organizacao", method=RequestMethod.POST)
	    public ResponseEntity<Organizacao> createOrganizacao(@RequestBody Organizacao organizacao) {
	    	Organizacao ong = organizacaoRepository.save(organizacao);
			return new ResponseEntity<Organizacao>(ong, HttpStatus.OK);

	    }

}
