package es.unican.hapisecurity.common;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Clase con los atributos de cada caracteristica
 */
@Entity(tableName = "caracteristicas")
public class Caracteristica implements Serializable {

    @SerializedName(value="id")
    @PrimaryKey(autoGenerate = true)
    private Long caracteristicaId;
    @SerializedName(value="texto")
    @ColumnInfo(name = "texto")
    private String texto;

    public Caracteristica() {
        this.caracteristicaId = 0L;
    }

    @NonNull
    public Long getCaracteristicaId() {
        return caracteristicaId;
    }

    public void setCaracteristicaId(@NonNull Long id) {
        this.caracteristicaId = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
