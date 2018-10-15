package servicoRest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="conta_bancaria")

public class ContaBancaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idConta;
	private int codAgencia;
	private int codConta;
	private String nomeProprietario;
	private int tipoDoc;
	private String numDoc;
	private int idBanco;
	private int idCategoriaConta;
	private int idLocal;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idBanco", nullable = false, insertable = false, updatable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Banco banco;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCategoriaConta", nullable = false, insertable = false, updatable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CategoriaConta categoriaConta;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idLocal", nullable = false, insertable = false, updatable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Local local;
	

	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public ContaBancaria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdConta() {
		return idConta;
	}
	public void setIdConta(long idConta) {
		this.idConta = idConta;
	}
	public int getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}
	public int getCodConta() {
		return codConta;
	}
	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public int getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public int getIdCategoriaConta() {
		return idCategoriaConta;
	}
	public void setIdCategoriaConta(int idCategoriaConta) {
		this.idCategoriaConta = idCategoriaConta;
	}
	
}
