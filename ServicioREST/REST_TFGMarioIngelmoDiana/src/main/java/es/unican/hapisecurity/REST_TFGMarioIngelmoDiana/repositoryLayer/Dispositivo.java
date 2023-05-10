package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dispositivo {
	
	@Id
	private String id;
	private byte[] imagen;
	private String nombre;
	private Categoria categoria;
	private String precio;
	private double seguridad;
	private String sostenibilidad;
	private List<Categoria> listaPositivaSeguridad;
	private List<Categoria> listaNegativaSeguridad;
	private List<Categoria> listaPositivaSostenibilidad;
	private List<Categoria> listaNegativaSostenibilidad;
	
	public Dispositivo () { }

	public Dispositivo(String id, byte[] imagen, String nombre, Categoria categoria, String precio, double seguridad,
			String sostenibilidad, List<Categoria> listaPositivaSeguridad, List<Categoria> listaNegativaSeguridad,
			List<Categoria> listaPositivaSostenibilidad, List<Categoria> listaNegativaSostenibilidad) {
		super();
		this.id = id;
		this.imagen = imagen;
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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

	public List<Categoria> getListaPositivaSeguridad() {
		return listaPositivaSeguridad;
	}

	public void setListaPositivaSeguridad(List<Categoria> listaPositivaSeguridad) {
		this.listaPositivaSeguridad = listaPositivaSeguridad;
	}

	public List<Categoria> getListaNegativaSeguridad() {
		return listaNegativaSeguridad;
	}

	public void setListaNegativaSeguridad(List<Categoria> listaNegativaSeguridad) {
		this.listaNegativaSeguridad = listaNegativaSeguridad;
	}

	public List<Categoria> getListaPositivaSostenibilidad() {
		return listaPositivaSostenibilidad;
	}

	public void setListaPositivaSostenibilidad(List<Categoria> listaPositivaSostenibilidad) {
		this.listaPositivaSostenibilidad = listaPositivaSostenibilidad;
	}

	public List<Categoria> getListaNegativaSostenibilidad() {
		return listaNegativaSostenibilidad;
	}

	public void setListaNegativaSostenibilidad(List<Categoria> listaNegativaSostenibilidad) {
		this.listaNegativaSostenibilidad = listaNegativaSostenibilidad;
	}

}
