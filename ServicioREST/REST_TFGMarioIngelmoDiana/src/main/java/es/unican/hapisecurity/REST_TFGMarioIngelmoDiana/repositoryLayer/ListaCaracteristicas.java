package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import java.util.List;

public class ListaCaracteristicas {

	private List<Caracteristica> caracteristicas;

	public ListaCaracteristicas() {

	}

	public ListaCaracteristicas(List<Caracteristica> caracteristicas) {
		super();
		this.caracteristicas = caracteristicas;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
