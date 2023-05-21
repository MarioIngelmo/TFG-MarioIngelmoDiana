package es.unican.hapisecurity.common;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Clase con los atributos de cada dispositivo
 */
@Entity(tableName = "dispositivos")
public class Dispositivo implements Serializable {

    @SerializedName(value="id")
    @NonNull
    @PrimaryKey
    private String id;
    @SerializedName(value="urlImagen")
    @ColumnInfo(name = "urlImagen")
    private String urlImagen;
    @SerializedName(value="nombre")
    @ColumnInfo(name = "nombre")
    private String nombre;
    @SerializedName(value="marca")
    @ColumnInfo(name = "marca")
    private String marca;
    @SerializedName(value="descripcion")
    @ColumnInfo(name = "descripcion")
    private String descripcion;
    @SerializedName(value="categoria")
    @ColumnInfo(name = "categoria")
    private Categoria categoria;
    @SerializedName(value="precio")
    @ColumnInfo(name = "precio")
    private String precio;
    @SerializedName(value="seguridad")
    @ColumnInfo(name = "seguridad")
    private int seguridad;
    @SerializedName(value="sostenibilidad")
    @ColumnInfo(name = "sostenibilidad")
    private String sostenibilidad;
    @SerializedName(value="listaPositivaSeguridad")
    @Embedded
    private List<Caracteristica> listaPositivaSeguridad;
    @SerializedName(value="listaNegativaSeguridad")
    @Embedded
    private List<Caracteristica> listaNegativaSeguridad;
    @SerializedName(value="listaPositivaSostenibilidad")
    @Embedded
    private List<Caracteristica> listaPositivaSostenibilidad;
    @SerializedName(value="listaNegativaSostenibilidad")
    @Embedded
    private List<Caracteristica> listaNegativaSostenibilidad;

    public Dispositivo() {
        this.id = "";
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
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

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
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
