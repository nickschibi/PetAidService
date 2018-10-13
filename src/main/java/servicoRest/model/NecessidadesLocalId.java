package servicoRest.model;

import java.io.Serializable;

public class NecessidadesLocalId implements Serializable {

	public NecessidadesLocalId() {
		super();
	}
	public NecessidadesLocalId(Long idLocal, Long idNecessidade) {
		super();
		this.idLocal = idLocal;
		this.idNecessidade = idNecessidade;
	}

	private Long idLocal;
	private Long idNecessidade;
	
	
	public Long getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}
	public Long getIdNecessidades() {
		return idNecessidade;
	}
	public void setIdNecessidades(Long idNecessidades) {
		this.idNecessidade = idNecessidades;
	}
	
	private static final long serialVersionUID = -2834827403836993112L;

	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
	        result = prime * result + ((idNecessidade == null) ? 0 : idNecessidade.hashCode());
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
	        NecessidadesLocalId other = (NecessidadesLocalId) obj;
	        if (idLocal == null) {
	            if (other.idLocal != null)
	                return false;
	        } else if (!idLocal.equals(other.idLocal))
	            return false;
	        if (idNecessidade == null) {
	            if (other.idNecessidade != null)
	                return false;
	        } else if (!idNecessidade.equals(other.idNecessidade))
	            return false;
	        return true;
	    }
	
	
}
