package servicoRest.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import servicoRest.model.Voluntario;

public interface VoluntarioRepository extends CrudRepository<Voluntario, Long>{
	
	Optional<Voluntario> findById(Long id);

	Optional<Voluntario>findByEmail(String email);

	Iterable<Voluntario>findAllByEmail(String email);

}
