package servicoRest.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@IdClass(OrganizacaoEnderecoId.class)
@Table(name="local")
public class Local implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_local")
	private int idLocal;
	@Column(name="nome_responsavel")
	private String nomeResponsavel;
	@Column(name="telefone_local")
	private String telefoneLocal;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="id_organizacao")
	private Organizacao organizacao;
//	private Long idOrganizacao;
	public Organizacao getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(Organizacao organizacao) {
		this.organizacao = organizacao;
	}
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="id_endereco")
	private Endereco endereco;
//	private Long idEndereco;
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
    
    
////@Id
////@GeneratedValue(strategy = GenerationType.IDENTITY)
////private int idLocal;
//
//@EmbeddedId
//private OrganizacaoEnderecoId id;
//
////@ManyToOne(fetch = FetchType.LAZY)
////@JoinColumn(name = "id_organizacao")
////private Organizacao organizacao;
////
////@ManyToOne(fetch = FetchType.LAZY)
////@JoinColumn(name = "id_endereco")
////private Endereco endereco;
//
//@ManyToOne(fetch = FetchType.LAZY)
//@MapsId("idEndereco")
//private Endereco endereco;
//
//@ManyToOne(fetch = FetchType.LAZY)
//@MapsId("idOrganizacao")
//private Organizacao organizacao;
//
//    
//
//

////private int idOrganizacao;
////private int id_endereco;
//
//public Local(int idLocal, String nomeResponsavel, String telefoneLocal, int idOrganizacao, int id_endereco) {
//    //this.idLocal = idLocal;
//    this.nomeResponsavel = nomeResponsavel;
//    this.telefoneLocal = telefoneLocal;
//    //this.idOrganizacao = idOrganizacao;
//   // this.id_endereco = id_endereco;
//}
//
//public Local(){
//
//};
//
//public Local(String nomeResponsavel, String telefoneLocal, int idOrganizacao, int id_endereco) {
//    this.nomeResponsavel = nomeResponsavel;
//    this.telefoneLocal = telefoneLocal;
//    //this.idOrganizacao = idOrganizacao;
//    //this.id_endereco = id_endereco;
//}
//
////public int getIdLocal() {
////    return idLocal;
////}
////
////public void setIdLocal(int idLocal) {
////    this.idLocal = idLocal;
////}

//    public int getIdOrganizacao() {
//        return idOrganizacao;
//    }
//
//    public void setIdOrganizacao(int idOrganizacao) {
//        this.idOrganizacao = idOrganizacao;
//    }

//    public int getId_endereco() {
//        return id_endereco;
//    }
//
//    public void setId_endereco(int id_endereco) {
//        this.id_endereco = id_endereco;
//    }


//	public Organizacao getOrganizacao() {
//		return organizacao;
//	}
//
//	public void setOrganizacao(Organizacao organizacao) {
//		this.organizacao = organizacao;
//	}

//	public long getIdEndereco(){
//		return endereco.getIdEndereco();
//	}
//    
//	public long getIdOrganizacao(){
//		return organizacao.getIdOrganizacao();
//	}
    
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(organizacao, endereco);
//    } 
}

