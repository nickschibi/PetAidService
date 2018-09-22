package servicoRest.model;

import java.io.Serializable;


public class OrganizacaoEnderecoId implements Serializable{
	
	private Organizacao organizacao;
	private Endereco endereco;


	private static final long serialVersionUID = -2834827403836993112L;

	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((organizacao == null) ? 0 : organizacao.hashCode());
	        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
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
	        if (organizacao == null) {
	            if (other.organizacao != null)
	                return false;
	        } else if (!organizacao.equals(other.organizacao))
	            return false;
	        if (endereco == null) {
	            if (other.endereco != null)
	                return false;
	        } else if (!endereco.equals(other.endereco))
	            return false;
	        return true;
	    }
}
