package servicoRest.model;

import java.io.Serializable;


public class OrganizacaoEnderecoId implements Serializable{
	
	private Long idOrganizacao;
	private Long idEndereco;

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

	
	private static final long serialVersionUID = -2834827403836993112L;

	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((idOrganizacao == null) ? 0 : idOrganizacao.hashCode());
	        result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        OrganizacaoEnderecoId other = (OrganizacaoEnderecoId) obj;
	        if (idOrganizacao == null) {
	            if (other.idOrganizacao != null)
	                return false;
	        } else if (!idOrganizacao.equals(other.idOrganizacao))
	            return false;
	        if (idEndereco == null) {
	            if (other.idEndereco != null)
	                return false;
	        } else if (!idEndereco.equals(other.idEndereco))
	            return false;
	        return true;
	    }
}
