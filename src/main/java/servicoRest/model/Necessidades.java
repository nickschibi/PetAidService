package servicoRest.model;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="necessidades")


public class Necessidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNecessidade;
	private String descricaoNecessidade;
	private boolean flagPrecisaObs;
	
//	@OneToMany(mappedBy = "necessidades", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private Set<NecessidadesLocal>necessidadesLocal;
//	
//	
//	public Set<NecessidadesLocal> getNecessidadeLocal() {
//	    return necessidadesLocal;
//	}
//	
//	public void setNecessidadesLocal(Set<NecessidadesLocal> necessidadesLocal) {
//	    this.necessidadesLocal = necessidadesLocal;
//	}
//		
	
	public long getIdNecessidade() {
		return idNecessidade;
	}
	public void setIdNecessidade(long idNecessidade) {
		this.idNecessidade = idNecessidade;
	}
	public String getDescricaoNecessidade() {
		return descricaoNecessidade;
	}
	public void setDescricaoNecessidade(String descricaoNecessidade) {
		this.descricaoNecessidade = descricaoNecessidade;
	}
	public boolean isFlagPrecisaObs() {
		return flagPrecisaObs;
	}
	public void setFlagPrecisaObs(boolean flagPrecisaObs) {
		this.flagPrecisaObs = flagPrecisaObs;
	}
	
}
