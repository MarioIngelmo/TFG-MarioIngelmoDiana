package es.unican.hapisecurity.repository.db;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Dispositivo;

public class DispositivoConCaracteristicas {
    @Embedded
    private Dispositivo dispositivo;

    @Relation(parentColumn = "dispositivoId",
            entityColumn = "caracteristicaId",
            associateBy = @Junction(DispositivoCaracteristicaPositivaSeguridad.class))
    private List<Caracteristica> positivasSeguridad;

    @Relation(parentColumn = "dispositivoId",
            entityColumn = "caracteristicaId",
            associateBy = @Junction(DispositivoCaracteristicaNegativaSeguridad.class))
    private List<Caracteristica> negativasSeguridad;

    @Relation(parentColumn = "dispositivoId",
            entityColumn = "caracteristicaId",
            associateBy = @Junction(DispositivoCaracteristicaPositivaSostenibilidad.class))
    private List<Caracteristica> positivasSostenibilidad;

    @Relation(parentColumn = "dispositivoId",
            entityColumn = "caracteristicaId",
            associateBy = @Junction(DispositivoCaracteristicaNegativaSostenibilidad.class))
    private List<Caracteristica> negativasSostenibilidad;

    public DispositivoConCaracteristicas() {}

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<Caracteristica> getPositivasSeguridad() {
        return positivasSeguridad;
    }

    public void setPositivasSeguridad(List<Caracteristica> positivasSeguridad) {
        this.positivasSeguridad = positivasSeguridad;
    }

    public List<Caracteristica> getNegativasSeguridad() {
        return negativasSeguridad;
    }

    public void setNegativasSeguridad(List<Caracteristica> negativasSeguridad) {
        this.negativasSeguridad = negativasSeguridad;
    }

    public List<Caracteristica> getPositivasSostenibilidad() {
        return positivasSostenibilidad;
    }

    public void setPositivasSostenibilidad(List<Caracteristica> positivasSostenibilidad) {
        this.positivasSostenibilidad = positivasSostenibilidad;
    }

    public List<Caracteristica> getNegativasSostenibilidad() {
        return negativasSostenibilidad;
    }

    public void setNegativasSostenibilidad(List<Caracteristica> negativasSostenibilidad) {
        this.negativasSostenibilidad = negativasSostenibilidad;
    }

}
