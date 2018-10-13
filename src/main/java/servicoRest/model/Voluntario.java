package servicoRest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voluntario")
public class Voluntario {

	@Id
	private long id_voluntario;
	private String nome_voluntario;
	private String email;
	private String telefone_voluntario;
	
	
	public Voluntario() {
		
	}
	
	public Voluntario(long id_voluntario, String nome_voluntario, String email, String telefone_voluntario
			) {
		super();
		this.id_voluntario = id_voluntario;
		this.nome_voluntario = nome_voluntario;
		this.email = email;
		this.telefone_voluntario = telefone_voluntario;
		
	}
	
	public long getId_voluntario() {
		return id_voluntario;
	}
	public void setId_voluntario(int id_voluntario) {
		this.id_voluntario = id_voluntario;
	}
	public String getNome_voluntario() {
		return nome_voluntario;
	}
	public void setNome_voluntario(String nome_voluntario) {
		this.nome_voluntario = nome_voluntario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone_voluntario() {
		return telefone_voluntario;
	}
	public void setTelefone_voluntario(String telefone_voluntario) {
		this.telefone_voluntario = telefone_voluntario;
	}

}
