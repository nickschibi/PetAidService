package servicoRest.contollers;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import servicoRest.excpetion.NotFoundException;
import servicoRest.model.Livro;
import servicoRest.repository.LivroRepository;

@RestController
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	private static final String templateAutor = "Autor [%d]";
	private static final String templateTitulo = "Titulo [%d]";
    private final AtomicLong counter = new AtomicLong();
    
//    @RequestMapping(value= "/livro/{id}")
//    public Livro getLivro(@PathVariable int id) {
//        return new Livro(id, String.format(templateTitulo, id), String.format(templateAutor, id));
//    }

    @RequestMapping(value="/livro/{id}", method=RequestMethod.GET)
    public Livro getLivro(@PathVariable long id) {
		return livroRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/livro/", method=RequestMethod.GET)
    public Iterable<Livro> getLivros() {
		return livroRepository.findAll();
    }
    
    @RequestMapping(value="/livro/", method=RequestMethod.POST)
    public ResponseEntity<String> insertLivro(@RequestBody Livro livro) {
    	livroRepository.save(livro);
		return new ResponseEntity<String>("OK", HttpStatus.OK);

    }
    
}