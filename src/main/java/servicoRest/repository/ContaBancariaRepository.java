package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import servicoRest.model.ContaBancaria;


public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long>{
	
	Optional<ContaBancaria> findById(Long id);

	Iterable<ContaBancaria> findByIdLocal(int id_local);
	
}
