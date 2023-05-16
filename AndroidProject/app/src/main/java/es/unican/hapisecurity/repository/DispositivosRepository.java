package es.unican.hapisecurity.repository;

import android.content.Context;
import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.common.DispositivosResponse;
import es.unican.hapisecurity.repository.REST.DispositivosService;

/**
 * Implementation of a gas stations repository.
 * In this case, the gas stations are retrieved from a REST API.
 * The repository also persists into a local DB the retrieved list of gas stations.
 */
public class DispositivosRepository implements IDispositivosRepository {

    private static final String KEY_LAST_SAVED = "KEY_LAST_SAVED";

    private final Context context;

    public DispositivosRepository(final Context context) {
        this.context = context;
    }

    @Override
    public List<Dispositivo> getDispositivos(String categoria, String seguridad, String sostenibilidad) {

        DispositivosResponse response = DispositivosService.getDispositivos(categoria, seguridad, sostenibilidad);
        List<Dispositivo> dispositivos = response != null ? response.getDispositivos() : null;
        return dispositivos;
    }

    @Override
    public Dispositivo getDispositivoId(String id) {
        DispositivosResponse response = DispositivosService.getDispositivoId(id);
        Dispositivo dispositivo = response != null ? response.getDispositivos().get(0) : null;
        return dispositivo;
    }

}
