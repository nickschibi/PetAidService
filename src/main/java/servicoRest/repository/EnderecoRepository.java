package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import servicoRest.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    Optional<Endereco> findById(Long id);
}


