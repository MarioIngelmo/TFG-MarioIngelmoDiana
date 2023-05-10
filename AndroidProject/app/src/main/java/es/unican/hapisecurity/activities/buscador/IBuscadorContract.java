package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;

public interface IBuscadorContract {
    
    interface View {
        void cierraDialogo(AlertDialog dialog);

        void guardaValorFiltros(String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal);
    }
    
    interface Presenter {

        void cancelarFiltros(AlertDialog dialog);

        void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal);
    }
}
