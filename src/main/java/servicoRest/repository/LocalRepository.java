package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import servicoRest.model.Local;

public interface LocalRepository extends CrudRepository<Local, Long> {
	
    Optional<Local> findById(Long id);

	Iterable<Local> findByOrganizacao_IdOrganizacao(Long id_organizacao);
	
}

