package es.unican.hapisecurity.repository.db;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Dispositivo;

public class AuxiliarDB {

    private AuxiliarDB() {
        // Constructor vacio
    }

    public static void anhadeDB(IDispositivosDAO dao, Dispositivo dispositivo) {
        dao.insertDispositivo(dispositivo);
        for (Caracteristica c: dispositivo.getListaPositivaSeguridad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaPositivaSeguridad carac = new DispositivoCaracteristicaPositivaSeguridad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertPositivaSeguridad(carac);
        }
        for (Caracteristica c: dispositivo.getListaNegativaSeguridad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaNegativaSeguridad carac = new DispositivoCaracteristicaNegativaSeguridad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertNegativaSeguridad(carac);
        }
        for (Caracteristica c: dispositivo.getListaPositivaSostenibilidad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaPositivaSostenibilidad carac = new DispositivoCaracteristicaPositivaSostenibilidad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertPositivaSostenibilidad(carac);
        }
        for (Caracteristica c: dispositivo.getListaNegativaSostenibilidad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaNegativaSostenibilidad carac = new DispositivoCaracteristicaNegativaSostenibilidad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertNegativaSostenibilidad(carac);
        }
    }

    public static void eliminaDB(IDispositivosDAO dao, String id) {
        dao.eliminaDispositivo(id);
        dao.eliminaPositivaSeguridad(id);
        dao.eliminaNegativaSeguridad(id);
        dao.eliminaPositivaSostenibilidad(id);
        dao.eliminaNegativaSostenibilidad(id);
    }
}
