package es.unican.hapisecurity.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Clase con los atributos de cada dispositivo
 */
public class Dispositivo {

    @SerializedName(value="id")
    private String id;
    @SerializedName(value="urlImagen")
    private String urlImagen;
    @SerializedName(value="nombre")
    private String nombre;
    @SerializedName(value="marca")
    private String marca;
    @SerializedName(value="descripcion")
    private String descripcion;
    @SerializedName(value="categoria")
    private Categoria categoria;
    @SerializedName(value="precio")
    private String precio;
    @SerializedName(value="seguridad")
    private double seguridad;
    @SerializedName(value="sostenibilidad")
    private String sostenibilidad;
    @SerializedName(value="listaPositivaSeguridad")
    private List<Caracteristica> listaPositivaSeguridad;
    @SerializedName(value="listaNegativaSeguridad")
    private List<Caracteristica> listaNegativaSeguridad;
    @SerializedName(value="listaPositivaSostenibilidad")
    private List<Caracteristica> listaPositivaSostenibilidad;
    @SerializedName(value="listaNegativaSostenibilidad")
    private List<Caracteristica> listaNegativaSostenibilidad;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
