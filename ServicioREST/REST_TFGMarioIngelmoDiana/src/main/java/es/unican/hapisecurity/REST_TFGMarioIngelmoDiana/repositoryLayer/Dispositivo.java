package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Dispositivo {
	
	@Id
	private String id;
	private String urlImagen;
	private String nombre;
	private Categoria categoria;
	private String precio;
	private double seguridad;
	private String sostenibilidad;
	@ManyToMany
	// TODO
	private List<Caracteristica> listaPositivaSeguridad;
	@ManyToMany
	// TODO
	private List<Caracteristica> listaNegativaSeguridad;
	@ManyToMany
	// TODO
	private List<Caracteristica> listaPositivaSostenibilidad;
	@ManyToMany
	// TODO
	private List<Caracteristica> listaNegativaSostenibilidad;
	
	public Dispositivo () { }

	public Dispositivo(String id, String urlImagen, String nombre, Categoria categoria, String precio, double seguridad,
			String sostenibilidad, List<Caracteristica> listaPositivaSeguridad, List<Caracteristica> listaNegativaSeguridad,
			List<Caracteristica> listaPositivaSostenibilidad, List<Caracteristica> listaNegativaSostenibilidad) {
		super();
		this.id = id;
		this.urlImagen = urlImagen;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.seguridad = seguridad;
		this.sostenibilidad = sostenibilidad;
		this.listaPositivaSeguridad = listaPositivaSeguridad;
		this.listaNegativaSeguridad = listaNegativaSeguridad;
		this.listaPositivaSostenibilidad = listaPositivaSostenibilidad;
		this.listaNegativaSostenibilidad = listaNegativaSostenibilidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public double getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(double seguridad) {
		this.seguridad = seguridad;
	}

	public String getSostenibilidad() {
		return sostenibilidad;
	}

	public void setSostenibilidad(String sostenibilidad) {
		this.sostenibilidad = sostenibilidad;
	}

	public List<Caracteristica> getListaPositivaSeguridad() {
		return listaPositivaSeguridad;
	}

	public void setListaPositivaSeguridad(List<Caracteristica> listaPositivaSeguridad) {
		this.listaPositivaSeguridad = listaPositivaSeguridad;
	}

	public List<Caracteristica> getListaNegativaSeguridad() {
		return listaNegativaSeguridad;
	}

	public void setListaNegativaSeguridad(List<Caracteristica> listaNegativaSeguridad) {
		this.listaNegativaSeguridad = listaNegativaSeguridad;
	}

	public List<Caracteristica> getListaPositivaSostenibilidad() {
		return listaPositivaSostenibilidad;
	}

	public void setListaPositivaSostenibilidad(List<Caracteristica> listaPositivaSostenibilidad) {
		this.listaPositivaSostenibilidad = listaPositivaSostenibilidad;
	}

	public List<Caracteristica> getListaNegativaSostenibilidad() {
		return listaNegativaSostenibilidad;
	}

	public void setListaNegativaSostenibilidad(List<Caracteristica> listaNegativaSostenibilidad) {
		this.listaNegativaSostenibilidad = listaNegativaSostenibilidad;
	}

}
