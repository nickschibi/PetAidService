package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import servicoRest.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
    Optional<Endereco> findById(Long id);
    
}


