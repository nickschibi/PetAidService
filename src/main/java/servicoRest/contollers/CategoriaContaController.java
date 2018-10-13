package servicoRest.contollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.model.CategoriaConta;
import servicoRest.repository.CategoriaContaRepository;;

@RestController
public class CategoriaContaController {
	@Autowired
	CategoriaContaRepository categoriaContaRepository;
	
	@RequestMapping(value="/categoriaConta/{id}", method=RequestMethod.GET)
    public CategoriaConta getCategoriaConta(@PathVariable long id) {
		return categoriaContaRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/categoriaConta", method=RequestMethod.GET)
    public Iterable<CategoriaConta> getCategoriaConta() {
		return categoriaContaRepository.findAll();
    }

}
