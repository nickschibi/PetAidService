package servicoRest.contollers;

import java.util.NoSuchElementException;

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
import servicoRest.model.Local;
import servicoRest.model.NecessidadesLocal;
import servicoRest.model.NecessidadesLocalId;
import servicoRest.repository.NecessidadesLocalRepository;

@RestController
public class NecessidadesLocalController {
	
	@Autowired
	private NecessidadesLocalRepository necessidadesLocalRepository;
	

	    @RequestMapping(value="/necessidadesLocal", method=RequestMethod.GET)
	    public Iterable<NecessidadesLocal> getNecessidadesLocal(@RequestParam(value="id_local", required=false) String id_local, @RequestParam(value="id_necessidade", required=false) String id_necessidade) {
	    	if(id_local == null) {
	    		return necessidadesLocalRepository.findAll();
	    	} else if (id_necessidade == null){
	    		return necessidadesLocalRepository.findByLocal_IdLocal(Long.parseLong(id_local));
	    	} else {
	    		return necessidadesLocalRepository.findByIdNecessidadeAndIdLocal(Long.parseLong(id_necessidade), Long.parseLong(id_local));
	    	}
	    }

	    @RequestMapping(value="/necessidadesLocal", method=RequestMethod.POST)
	    public ResponseEntity<NecessidadesLocal> createNecessidadesLocal(@RequestBody NecessidadesLocal necessidadesLocal) {
	    	NecessidadesLocal nl = necessidadesLocalRepository.save(necessidadesLocal);
			return new ResponseEntity<NecessidadesLocal>(nl, HttpStatus.OK);

	    }
		

	    @Transactional
	    @RequestMapping(value="/necessidadesLocal", method=RequestMethod.DELETE)
	    public ResponseEntity<String> deleteNecessidadesLocal(@RequestParam(value="id_local", required=true) String id_local, @RequestParam(value="id_necessidade", required=true) String id_necessidade) {
			necessidadesLocalRepository.deleteByIdNecessidadeAndIdLocal(Long.parseLong(id_necessidade), Long.parseLong(id_local));
			return new ResponseEntity<String>("OK", HttpStatus.OK);
	    }
	   
	    @RequestMapping(value = "/necessidadesLocal/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateNecessidadesLocal(@RequestBody NecessidadesLocal necessidadesLocal, @PathVariable long id) {

			NecessidadesLocal nl;
			try {
				nl = necessidadesLocalRepository.findByIdLocal(id).get();

			} catch (NoSuchElementException e) {
				return new ResponseEntity<String>("Necessidades nao encontradas.", HttpStatus.NOT_FOUND);
			}

			nl.setObservacao(necessidadesLocal.getObservacao());
			

			necessidadesLocalRepository.save(nl);
			return new ResponseEntity<NecessidadesLocal>(nl, HttpStatus.OK);
		}
	

}
