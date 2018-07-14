package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import servicoRest.model.Livro;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LivroRepository extends CrudRepository<Livro, Long> {
    Optional<Livro> findById(Long id);
}