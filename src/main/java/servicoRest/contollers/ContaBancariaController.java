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
import servicoRest.model.ContaBancaria;

import servicoRest.repository.ContaBancariaRepository;

@RestController
public class ContaBancariaController {
	
	
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@RequestMapping(value="/contaBancaria/{id}", method=RequestMethod.GET)
    public ContaBancaria getContaBancaria(@PathVariable long id) {
		return contaBancariaRepository.findById(id).orElseThrow(NotFoundException::new);
    }


    
    @RequestMapping(value="/contaBancaria", method=RequestMethod.GET)
    public Iterable<ContaBancaria> getContaBAncaria(
    		@RequestParam(value="id_local", required=false) String id_local) {
    	if(id_local != null) {
    		return contaBancariaRepository.findByIdLocal(Integer.parseInt(id_local));
    	} else {
    		return contaBancariaRepository.findAll();
    	}
    }
    
    
    
    @RequestMapping(value="/contaBancaria", method=RequestMethod.POST)
    public ResponseEntity<ContaBancaria> createContaBancaria(@RequestBody ContaBancaria contaBancaria) {
    	ContaBancaria conta = contaBancariaRepository.save(contaBancaria);
		return new ResponseEntity<ContaBancaria>(conta, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value="/contaBancaria/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteContaBancaria(@PathVariable long id) {
    	contaBancariaRepository.deleteById(id);
		return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/contaBancaria/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateContaBancaria(@RequestBody ContaBancaria contaBancaria, @PathVariable long id) {

		ContaBancaria c;
		try {
			c = contaBancariaRepository.findById(id).get();

		} catch (NoSuchElementException n) {
			return new ResponseEntity<String>("Conta Bancaria não encontrada", HttpStatus.NOT_FOUND);
		}

		c.setCodAgencia(contaBancaria.getCodAgencia());
		c.setCodConta(contaBancaria.getCodConta());
		c.setIdBanco(contaBancaria.getIdBanco());
		c.setIdCategoriaConta(contaBancaria.getIdCategoriaConta());
		c.setTipoDoc(contaBancaria.getTipoDoc());
		c.setNumDoc(contaBancaria.getNumDoc());
		c.setNomeProprietario(contaBancaria.getNomeProprietario());
		

		contaBancariaRepository.save(c);
		return new ResponseEntity<ContaBancaria>(c, HttpStatus.OK);
	}

}
