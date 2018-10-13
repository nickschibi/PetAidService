package servicoRest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import servicoRest.model.Necessidades;

public interface NecessidadesRepository extends JpaRepository<Necessidades, Long> {
	
    Optional<Necessidades> findById(Long id);
}
