package servicoRest.contollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.model.Banco;
import servicoRest.repository.BancoRepository;

@RestController
public class BancoController {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@RequestMapping(value="/banco/{id}", method=RequestMethod.GET)
    public Banco getBanco(@PathVariable long id) {
		return bancoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/banco", method=RequestMethod.GET)
    public Iterable<Banco> getBanco() {
		return bancoRepository.findAll();
    }

}
