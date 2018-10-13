package servicoRest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import servicoRest.model.NecessidadesLocal;
import servicoRest.model.NecessidadesLocalId;;

public interface NecessidadesLocalRepository  extends JpaRepository<NecessidadesLocal, Long>{

	  //void deleteByIdNecessidadesLocal(Long id);
	  
	  //void deleteByNecessidadeLocalId(NecessidadesLocalId id);

	  Iterable<NecessidadesLocal> findByIdNecessidadeAndIdLocal(Long id_necessidade, Long id_local);
	  
	  Optional<NecessidadesLocal> findByIdLocal(Long id);

	  Iterable<NecessidadesLocal> findByLocal_IdLocal(long id_local);

	  void deleteByIdNecessidadeAndIdLocal(long id_necessidade, long id_local);
	    
	  //Iterable<Local> findByOrganizacao_IdOrganizacao(Long id_organizacao);

}
