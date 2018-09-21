package servicoRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import servicoRest.model.Organizacao;

public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long>{
	
	Optional<Organizacao> findById(Long id);
	
	Optional<Organizacao>findByEmail(String email);
	
//	
//	@Query("select o from Organizacao o inner join Endereco e where e.id_endereco = :id_endereco")
//	Iterable<Organizacao> findByIdEndereco(@Param("id_endereco") Long id_endereco);
//	

//	Iterable<Organizacao> findByLocais_Id_IdEndereco(Long id_endereco);
}
