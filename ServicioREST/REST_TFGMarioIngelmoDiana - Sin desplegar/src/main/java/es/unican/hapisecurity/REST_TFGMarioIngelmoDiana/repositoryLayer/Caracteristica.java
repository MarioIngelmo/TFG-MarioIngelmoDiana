package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Caracteristica {

	@Id
	@GeneratedValue
	private Long id;
	private String texto;

	public Caracteristica() {
	}

	public Caracteristica(Long id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
