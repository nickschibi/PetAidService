package servicoRest.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "organizacao")
public class Organizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrganizacao;
	@Column(name="nm_cnpj")
	private String nmCnpj;
	@Column(name="razao_social")
	private String razaoSocial;
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	@Column(name="email")
	private String email;
	@Column(name="descricao")
	private String descricao;
	@Column(name="site")
	private String site;
	@Column(name="facebook")
	private String facebook;
	@Column(name="instagram")
	private String instagram;
	
	
	public Organizacao() {
		
	}

	public long getIdOrganizacao() {
		return idOrganizacao;
	}

	public void setIdOrganizacao(long idOrganizacao) {
		this.idOrganizacao = idOrganizacao;
	}

	public String getNmCnpj() {
		return nmCnpj;
	}

	public void setNmCnpj(String nmCnpj) {
		this.nmCnpj = nmCnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public Organizacao(long idOrganizacao, String nmCnpj, String razaoSocial, String nomeFantasia, String email,
			String descricao, String site, String facebook, String instagram) {
		super();
		this.idOrganizacao = idOrganizacao;
		this.nmCnpj = nmCnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.descricao = descricao;
		this.site = site;
		this.facebook = facebook;
		this.instagram = instagram;
	}
	
	
//	 @ManyToMany(mappedBy = "ongs")
//	    private Set<Endereco> enderecos = new HashSet<>();

//    @OneToMany(
//        mappedBy = "organizacao", 
//        cascade = CascadeType.ALL, 
//        orphanRemoval = true
//    )
//    private List<Local> locais = new ArrayList<>();
	
//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "local", joinColumns = @JoinColumn(name = "id_organizacao", referencedColumnName = "id_organizacao"),
//    inverseJoinColumns = @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco"))
//    public Set<Endereco> getEnderecos() {
//        return enderecos;
//    }
//	  public void setEndereco(Set<Endereco>enderecos) {
//	        this.enderecos = enderecos;
//	    }
	
	 @OneToMany(mappedBy = "organizacao", cascade = CascadeType.ALL, orphanRemoval = true)
	 private Set<Local>locais;
	    public Set<Local>   getLocais() {
	        return locais;
	    }

	    public void setLocais(Set<Local> locais) {
	        this.locais = locais;
	    }
	
		
}
