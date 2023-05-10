package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;
import android.view.View;

public class BuscadorPresenter implements IBuscadorContract.Presenter {

    private IBuscadorContract.View view;

    public BuscadorPresenter(IBuscadorContract.View view) {
        this.view = view;
    }

    @Override
    public void cancelarFiltros(AlertDialog dialog) {
        view.cierraDialogo(dialog);
    }

    @Override
    public void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal) {
        view.guardaValorFiltros(categoriaTemporal, valorSeguridadTemporal, valorSostenibilidadTemporal);
        view.cierraDialogo(dialog);
    }
}
