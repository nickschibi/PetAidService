package servicoRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@IdClass(NecessidadesLocalId.class)
@Table(name="necessidades_local")
public class NecessidadesLocal {

	@Column(name="observacao")
	private String observacao;
	@Id
	@Column(name="id_local")
	private long idLocal;
	@Id
	@Column(name="id_necessidade")
	private long idNecessidade;
	
	
	@ManyToOne
	@JoinColumn(name="id_local",insertable = false,updatable = false)
	@JsonIgnore
	private Local local;

	@ManyToOne
	@JoinColumn(name="id_necessidade",insertable = false,updatable = false)
	private Necessidades necessidades;
	
	
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public long getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}
	public long getIdNecessidade() {
		return idNecessidade;
	}
	public void setIdNecessidade(long idNecessidade) {
		this.idNecessidade = idNecessidade;
	}
	
}
