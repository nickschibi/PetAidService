package servicoRest.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.repository.OrganizacaoRepository;
import servicoRest.repository.VoluntarioRepository;

@RestController
public class UserController {

	@Autowired
	private VoluntarioRepository voluntarioRepository;
	@Autowired
	private OrganizacaoRepository organizacaoRepository;

	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public String getUserType(@PathVariable String email) {
		String tipo;
		try {
			organizacaoRepository.findByEmail(email).orElseThrow(NotFoundException::new);
			tipo = "ong";
			return tipo;
		} catch (NotFoundException e) {

		}
		try {
			voluntarioRepository.findByEmail(email).orElseThrow(NotFoundException::new);
			tipo = "vol";
			return tipo;
		} catch (NotFoundException e) {

		}

		return "nada";

	}
}
