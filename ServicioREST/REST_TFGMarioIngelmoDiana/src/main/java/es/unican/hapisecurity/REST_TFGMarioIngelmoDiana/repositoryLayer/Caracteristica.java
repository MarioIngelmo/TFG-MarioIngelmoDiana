package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Caracteristica {
	
	@Id
	private String id;
	private String texto;
	
	public Caracteristica() { }

	public Caracteristica(String id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
