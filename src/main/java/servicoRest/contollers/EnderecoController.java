package servicoRest.contollers;

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
	
	

}
