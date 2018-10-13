package servicoRest.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.repository.NecessidadesRepository;
import servicoRest.model.Necessidades;


@RestController
public class NecessidadesController {
	
	@Autowired
	private NecessidadesRepository necessidadesRepository;
	
		
	@RequestMapping(value="/necessidades/{id}", method=RequestMethod.GET)
	public Necessidades getNecessidades(@PathVariable long id) {
		return necessidadesRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value="/necessidades", method=RequestMethod.GET)
	public Iterable<Necessidades> getNecessidades() {
		return necessidadesRepository.findAll();
	}

}
