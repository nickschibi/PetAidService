package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import servicoRest.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {

    Optional<Local> findByIdLocal(Long id);

	Iterable<Local> findByOrganizacao_IdOrganizacao(Long id_organizacao);
	
}

