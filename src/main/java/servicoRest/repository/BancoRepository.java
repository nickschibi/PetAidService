package servicoRest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import servicoRest.model.Banco;


public interface BancoRepository extends JpaRepository<Banco, Long>{
	
	Optional<Banco> findById(Long id);
	
	


}
