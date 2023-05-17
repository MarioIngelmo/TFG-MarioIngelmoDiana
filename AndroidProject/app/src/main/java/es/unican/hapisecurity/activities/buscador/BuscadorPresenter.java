package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public class BuscadorPresenter implements IBuscadorContract.Presenter {

    private String categoriaSeleccionada = "Todas";
    private int valorSeguridad = 0;
    private String valorSostenibilidad = "G";
    private IBuscadorContract.View view;
    private IDispositivosRepository repositorioDispositivos;
    private Boolean red;
    private List<Dispositivo> dispositivosMostrados;

    public BuscadorPresenter(IBuscadorContract.View view, String categoria, String seguridad, String sostenibilidad, Boolean red) {
        this.view = view;
        this.red = red;
        this.init(categoria, seguridad, sostenibilidad);
    }

    @Override
    public void init(String categoria, String seguridad, String sostenibilidad) {
        if (repositorioDispositivos == null) {
            repositorioDispositivos = view.getRepositorioDispositivos();
        }
        if (repositorioDispositivos != null) {
            if (Boolean.TRUE.equals(red)) {
                obtenDispositivos(categoria, seguridad, sostenibilidad);
            } else {
                view.showErrorRed();
            }
        }
    }

    @Override
    public void cancelarFiltros(AlertDialog dialog) {
        view.cierraDialogo(dialog);
    }

    @Override
    public void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal) {
        if (categoriaSeleccionada.equals(categoriaTemporal) && valorSeguridad == valorSeguridadTemporal
                && valorSostenibilidad.equals(valorSostenibilidadTemporal)) {
            view.cierraDialogo(dialog);
        } else {
            if (categoriaTemporal.equals("Asistente Virtual")) {
                categoriaSeleccionada = "Asistente_Virtual";
            } else if (categoriaTemporal.equals("Electrodomesticos Inteligentes")) {
                categoriaSeleccionada = "Electrodomesticos_Inteligentes";
            } else {
                categoriaSeleccionada = categoriaTemporal;
            }
            valorSeguridad = valorSeguridadTemporal;
            valorSostenibilidad = valorSostenibilidadTemporal;
            view.guardaValorFiltros(categoriaTemporal, valorSeguridadTemporal, valorSostenibilidadTemporal);
            view.cierraDialogo(dialog);
            this.obtenDispositivos(categoriaSeleccionada, String.valueOf(valorSeguridad), valorSostenibilidad);
        }
    }

    @Override
    public void obtenDispositivos(String categoria, String seguridad, String sostenibilidad) {
        List<Dispositivo> dispositivosMostrar = repositorioDispositivos.getDispositivos(categoria, seguridad, sostenibilidad);
        if (dispositivosMostrar != null) {
            dispositivosMostrados = dispositivosMostrar;
            view.showDispositivos(dispositivosMostrar);
        } else {
            view.showErrorServidor();
        }
    }

    @Override
    public void onDispositivoClicked(int index) {
        if (dispositivosMostrados != null && index < dispositivosMostrados.size()) {
            Dispositivo dispositivo = dispositivosMostrados.get(index);
            view.openDispositivoDetails(dispositivo);
        }
    }


}
