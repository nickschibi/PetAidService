package servicoRest.contollers;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servicoRest.excpetion.NotFoundException;
import servicoRest.model.Endereco;
import servicoRest.repository.EnderecoRepository;

@RestController
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

    @RequestMapping(value="/endereco/{id}", method=RequestMethod.GET)
    public Endereco getEndereco(@PathVariable long id) {
		return enderecoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value="/endereco", method=RequestMethod.GET)
    public Iterable<Endereco> getEndereco() {
		return enderecoRepository.findAll();
    }
    
    @RequestMapping(value="/endereco", method=RequestMethod.POST)
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
    	Endereco end = enderecoRepository.save(endereco);
		return new ResponseEntity<Endereco>(end, HttpStatus.OK);
    }

    @RequestMapping(value="/endereco/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteEndereco(@PathVariable long id) {
		enderecoRepository.deleteById(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEndereco(@RequestBody Endereco endereco, @PathVariable long id) {

		Endereco e;
		try {
			e = enderecoRepository.findById(id).get();

		} catch (NoSuchElementException n) {
			return new ResponseEntity<String>("Endereco nao encontrado.", HttpStatus.NOT_FOUND);
		}

		e.setEnd(endereco.getEnd());
		e.setNumCasa(endereco.getNumCasa());
		e.setComplemento(endereco.getComplemento());
		e.setBairro(endereco.getBairro());
		e.setCidade(endereco.getCidade());
		e.setUf(endereco.getUf());
		e.setCep(endereco.getCep());

		enderecoRepository.save(e);
		return new ResponseEntity<Endereco>(e, HttpStatus.OK);
	}
    

}
