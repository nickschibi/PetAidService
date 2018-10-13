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
import servicoRest.repository.LocalRepository;

@RestController
public class LocalController {
			
	@Autowired
	private LocalRepository localRepository;

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
	

    @RequestMapping(value="/local/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteLocal(@PathVariable long id) {
		localRepository.deleteByIdLocal(id);
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



