package servicoRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {

    @Id
	private long id;
	private String titulo;
	private String autor;

	public Livro() {
	}

	public Livro(int id, String titulo, String autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
