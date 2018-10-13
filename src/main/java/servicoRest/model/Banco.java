package servicoRest.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banco")


public class Banco {
	@Id
	private int idBanco;
	private String nomeBanco;
	
	
	public int getIdBanco() {
		return idBanco;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public Banco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
