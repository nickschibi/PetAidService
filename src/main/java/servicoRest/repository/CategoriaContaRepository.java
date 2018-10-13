package servicoRest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import servicoRest.model.CategoriaConta;

public interface CategoriaContaRepository extends  JpaRepository<CategoriaConta, Long> {
	
	Optional<CategoriaConta> findById(Long id);
	
	
}
