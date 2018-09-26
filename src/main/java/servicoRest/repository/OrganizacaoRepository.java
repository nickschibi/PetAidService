package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import servicoRest.model.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long>{
	
	Optional<Organizacao> findById(Long id);
	
	Optional<Organizacao> findByEmail(String email);
	
	Iterable<Organizacao> findByLocais_Endereco_IdEndereco(Long id_endereco);
	
}
