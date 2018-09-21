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
import servicoRest.model.Local;
import servicoRest.repository.LocalRepository;

@RestController
public class LocalController {
			
		@Autowired
		private LocalRepository localRepository;
		
		private static final String templateId = "Id [%d]";
		private static final String templateNomeresponsavel = "Nome Responsavel [%s]";
		private static final String templateIdOrganizacao = "Id Organizacao [%s]";
		private static final String templateIdEndereco = "Id Endereco [%s]";
		private static final String templateTelefoneLocal = "Telefone [%s]";

	    

	    @RequestMapping(value="/local/{id}", method=RequestMethod.GET)
	    public Local getLocal(@PathVariable long id) {
			return localRepository.findById(id).orElseThrow(NotFoundException::new);
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
		
		

	}



