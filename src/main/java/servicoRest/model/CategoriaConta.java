package servicoRest.model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="categoria_conta")


public class CategoriaConta {
	@Id
	private int idCategoria;
	private String tipoConta;
	
	public CategoriaConta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	



}
