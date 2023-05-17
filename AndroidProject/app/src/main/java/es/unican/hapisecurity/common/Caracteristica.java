package es.unican.hapisecurity.common;

import com.google.gson.annotations.SerializedName;

/**
 * Clase con los atributos de cada caracteristica
 */
public class Caracteristica {

    @SerializedName(value="id")
    private Long id;
    @SerializedName(value="texto")
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
