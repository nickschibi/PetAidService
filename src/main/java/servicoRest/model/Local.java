package servicoRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrganizacaoEnderecoId.class)
@Table(name="local")
public class Local{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_local")
	private int idLocal;
	@Column(name="nome_responsavel")
	private String nomeResponsavel;
	@Column(name="telefone_local")
	private String telefoneLocal;

	@Column(name="id_organizacao")
	private long idOrganizacao;

	@Column(name="id_endereco")
	private long idEndereco;

	@ManyToOne
	@JoinColumn(name="id_organizacao",insertable = false,updatable = false)
	private Organizacao organizacao;

	@ManyToOne
	@JoinColumn(name="id_endereco",insertable = false,updatable = false)
	private Endereco endereco;
	
	public Organizacao getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefoneLocal() {
        return telefoneLocal;
    }

    public void setTelefoneLocal(String telefoneLocal) {
        this.telefoneLocal = telefoneLocal;
    }

	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public long getIdOrganizacao() {
		return idOrganizacao;
	}
	public void setIdOrganizacao(long idOrganizacao) {
		this.idOrganizacao = idOrganizacao;
	}
	public long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}
    
}

