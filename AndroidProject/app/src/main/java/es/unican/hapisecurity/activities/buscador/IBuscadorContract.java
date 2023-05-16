package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public interface IBuscadorContract {
    
    interface View {
        IDispositivosRepository getRepositorioDispositivos();
        void cierraDialogo(AlertDialog dialog);

        void guardaValorFiltros(String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal);

        void showDispositivos(List<Dispositivo> dispositivos);

        void showErrorRed();

        void showErrorServidor();
    }
    
    interface Presenter {

        void init(String categoria, String seguridad, String sostenibilidad);

        void cancelarFiltros(AlertDialog dialog);

        void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal);

        void obtenDispositivos(String categoria, String seguridad, String sostenibilidad);
    }
}
