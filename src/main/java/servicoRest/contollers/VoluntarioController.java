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
import servicoRest.model.Voluntariado;
import servicoRest.model.Voluntario;
import servicoRest.repository.VoluntariadoRepository;
import servicoRest.repository.VoluntarioRepository;

@RestController
public class VoluntarioController {
	@Autowired
	private VoluntarioRepository voluntarioRepository;
	
	@Autowired
	private VoluntariadoRepository voluntariadoRepository;

	@RequestMapping(value = "/voluntario/{id}", method = RequestMethod.GET)
	public Voluntario getVoluntario(@PathVariable long id) {
		return voluntarioRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/voluntario", method = RequestMethod.GET)
	public Iterable<Voluntario> getVoluntario(@RequestParam(value = "email", defaultValue = "") final String email) {
		if (email.equals("")) {
			return voluntarioRepository.findAll();
		} else {
			return voluntarioRepository.findAllByEmail(email);
		}
	}

	@RequestMapping(value = "/voluntario", method = RequestMethod.POST)
	public ResponseEntity<String> insertVoluntario(@RequestBody Voluntario voluntario) {
		voluntarioRepository.save(voluntario);
		return new ResponseEntity<String>("OK", HttpStatus.OK);

	}

	@RequestMapping(value = "/voluntario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteVoluntario(@PathVariable long id, @RequestParam(value="force", required=false) String force) {
		if(force != null && force.equals("true")) {
			Iterable<Voluntariado> voluntariados = voluntariadoRepository.findByIdVoluntario(id);
    		for(Voluntariado voluntariado: voluntariados) {
    			voluntariadoRepository.deleteById(voluntariado.getIdVoluntariado());
    		}
		}
		voluntarioRepository.deleteById(id);		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping(value = "/voluntario/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable long id) {

		Voluntario vol;
		try {
			vol = voluntarioRepository.findById(id).get();

		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>("Volunt�rio n�o encontrado.", HttpStatus.NOT_FOUND);
		}

		vol.setNome_voluntario(voluntario.getNome_voluntario());
		vol.setTelefone_voluntario(voluntario.getTelefone_voluntario());

		voluntarioRepository.save(vol);
		return new ResponseEntity<Voluntario>(vol, HttpStatus.OK);
	}
}
