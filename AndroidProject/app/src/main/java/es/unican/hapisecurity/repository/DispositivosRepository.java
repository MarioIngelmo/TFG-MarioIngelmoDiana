package es.unican.hapisecurity.repository;

import android.content.Context;
import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.common.DispositivosResponse;
import es.unican.hapisecurity.repository.rest.DispositivosService;

/**
 * Implementación del repositorio del servicio de dispositivos
 * Desde aquí se hacen las llamadas al servicio REST para obtener los datos buscados,
 * ya sea una lista de dispositivos o un dispositivo concreto
 */
public class DispositivosRepository implements IDispositivosRepository {

    private final Context context;

    public DispositivosRepository(final Context context) {
        this.context = context;
    }

    @Override
    public List<Dispositivo> getDispositivos(String categoria, String seguridad, String sostenibilidad, String ordenar) {
        DispositivosResponse response = DispositivosService.getDispositivos(categoria, seguridad, sostenibilidad, ordenar);
        return response != null ? response.getDispositivos() : null;
    }

    @Override
    public Dispositivo getDispositivoId(String id) {
        DispositivosResponse response = DispositivosService.getDispositivoId(id);
        return response != null ? response.getDispositivos().get(0) : null;
    }

}
