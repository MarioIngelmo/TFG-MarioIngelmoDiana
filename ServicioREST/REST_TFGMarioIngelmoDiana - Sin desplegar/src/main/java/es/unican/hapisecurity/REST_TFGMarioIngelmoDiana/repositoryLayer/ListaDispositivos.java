package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import java.util.List;

public class ListaDispositivos {

	private List<Dispositivo> dispositivos;

	public ListaDispositivos() {

	}

	public ListaDispositivos(List<Dispositivo> dispositivos) {
		super();
		this.dispositivos = dispositivos;
	}

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

}
