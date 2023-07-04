package es.unican.hapisecurity.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Clase con una lista de dispositivos, es lo que devuelve la llamada al
 * servicio al hacer un get de dispositivos
 */
public class DispositivosResponse {

    @SerializedName(value="dispositivos")
    private List<Dispositivo> dispositivos;

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

}
