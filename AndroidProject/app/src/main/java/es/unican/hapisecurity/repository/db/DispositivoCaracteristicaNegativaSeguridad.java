package es.unican.hapisecurity.repository.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "dispositivo_caracteristica_negativa_seguridad",
        primaryKeys = {"dispositivoId", "caracteristicaId"})
public class DispositivoCaracteristicaNegativaSeguridad {

    @NonNull
    public String dispositivoId;

    @NonNull
    public Long caracteristicaId;

    public DispositivoCaracteristicaNegativaSeguridad() {
        this.dispositivoId = "";
        this.caracteristicaId = 0L;
    }

    @NonNull
    public String getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(@NonNull String dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    @NonNull
    public Long getCaracteristicaId() {
        return caracteristicaId;
    }

    public void setCaracteristicaId(@NonNull Long caracteristicaId) {
        this.caracteristicaId = caracteristicaId;
    }

}
