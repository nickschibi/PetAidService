package servicoRest.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class OrganizacaoEnderecoId implements Serializable{

	@Column(name="id_local")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocal;
	
	@Column(name="id_organizacao")
	private Long idOrganizacao;
	
	@Column(name="id_endereco")
	private Long idEndereco;

	public Long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}

	public Long getIdOrganizacao() {
		return idOrganizacao;
	}

	public void setIdOrganizacao(Long idOrganizacao) {
		this.idOrganizacao = idOrganizacao;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public OrganizacaoEnderecoId() {}
	
	public OrganizacaoEnderecoId(Long idOrganizacao, Long idEndereco) {
		this.idOrganizacao = idOrganizacao;
		this.idEndereco = idEndereco;
	}

    @Override
    public int hashCode() {
        return Objects.hash(idOrganizacao, idEndereco);
    }
}
