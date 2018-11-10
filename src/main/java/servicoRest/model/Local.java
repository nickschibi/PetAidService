package servicoRest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@IdClass(OrganizacaoEnderecoId.class)
@Table(name="local")
public class Local{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_local")
	private long idLocal;
	
	@Column(name="nome_responsavel")
	private String nomeResponsavel;
	
	@Column(name="telefone_local")
	private String telefoneLocal;

	@Column(name="id_organizacao")
	private long idOrganizacao;

	@Column(name="id_endereco")
	private long idEndereco;

	@Column(name="media_nota")
	private Float mediaNota;
	
	@Column(name="count_necessidades")
	private int countNecessidades;
	
	@ManyToOne
	@JoinColumn(name="id_organizacao",insertable = false,updatable = false)
	@JsonIgnore
	private Organizacao organizacao;

	@ManyToOne
	@JoinColumn(name="id_endereco",insertable = false,updatable = false)
	private Endereco endereco;

	@OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<NecessidadesLocal>necessidadesLocal;
	
	
	public Set<NecessidadesLocal> getNecessidadeLocal() {
	    return necessidadesLocal;
	}
	
	public void setNecessidadesLocal(Set<NecessidadesLocal> necessidadesLocal) {
	    this.necessidadesLocal = necessidadesLocal;
	}
		
	
	
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

	public long getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(long idLocal) {
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

	public Float getMediaNota() {
		return mediaNota;
	}

	public void setMediaNota(Float mediaNota) {
		this.mediaNota = mediaNota;
	}

	public int getCountNecessidades() {
		return countNecessidades;
	}

	public void setCountNecessidades(int countNecessidades) {
		this.countNecessidades = countNecessidades;
	}
    
}

