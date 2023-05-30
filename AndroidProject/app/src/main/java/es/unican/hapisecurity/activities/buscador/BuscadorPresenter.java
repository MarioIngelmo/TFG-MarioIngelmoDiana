package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public class BuscadorPresenter implements IBuscadorContract.Presenter {

    private String categoriaSeleccionada = "Todas";
    private int valorSeguridad = 0;
    private String valorSostenibilidad = "G";
    private String ordenarSeleccionado = "Alfabetico";
    private final IBuscadorContract.View view;
    private IDispositivosRepository repositorioDispositivos;
    private final Boolean red;
    private List<Dispositivo> dispositivosMostrados;

    public BuscadorPresenter(IBuscadorContract.View view, String categoria, String seguridad, String sostenibilidad, String ordenar, Boolean red) {
        this.view = view;
        this.red = red;
        this.init(categoria, seguridad, sostenibilidad, ordenar);
    }

    @Override
    public void init(String categoria, String seguridad, String sostenibilidad, String ordenar) {
        if (repositorioDispositivos == null) {
            repositorioDispositivos = view.getRepositorioDispositivos();
        }
        if (repositorioDispositivos != null) {
            if (Boolean.TRUE.equals(red)) {
                obtenDispositivos(categoria, seguridad, sostenibilidad, ordenar);
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
    public void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal, String ordenarTemporal) {
        if (categoriaSeleccionada.equals(categoriaTemporal) && valorSeguridad == valorSeguridadTemporal
                && valorSostenibilidad.equals(valorSostenibilidadTemporal) && ordenarSeleccionado.equals(ordenarTemporal)) {
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
            ordenarSeleccionado = ordenarTemporal;
            view.guardaValorFiltros(categoriaTemporal, valorSeguridadTemporal, valorSostenibilidadTemporal, ordenarTemporal);
            view.cierraDialogo(dialog);
            this.obtenDispositivos(categoriaSeleccionada, String.valueOf(valorSeguridad), valorSostenibilidad, ordenarSeleccionado);
        }
    }

    @Override
    public void onDispositivoClicked(int index) {
        if (dispositivosMostrados != null && index < dispositivosMostrados.size()) {
            Dispositivo dispositivo = dispositivosMostrados.get(index);
            view.openDispositivoDetails(dispositivo);
        }
    }

    @Override
    public void filtraTexto(String textoBuscar) {
        if (textoBuscar.isBlank()) {
            obtenDispositivos(categoriaSeleccionada, String.valueOf(valorSeguridad), valorSostenibilidad, ordenarSeleccionado);
        }
        if (dispositivosMostrados != null && !dispositivosMostrados.isEmpty()) {
            List<Dispositivo> dispositivosTexto = new LinkedList<>();
            for (Dispositivo d : dispositivosMostrados) {
                if (d.getNombre().toLowerCase(Locale.ROOT).contains(textoBuscar.toLowerCase(Locale.ROOT)) || d.getMarca().toLowerCase(Locale.ROOT).contains(textoBuscar.toLowerCase(Locale.ROOT))) {
                    dispositivosTexto.add(d);
                }
            }
            dispositivosMostrados = dispositivosTexto;
            view.showDispositivos(dispositivosTexto);
        }
    }

    private void obtenDispositivos(String categoria, String seguridad, String sostenibilidad, String ordenarSeleccionado) {
        List<Dispositivo> dispositivosMostrar = repositorioDispositivos.getDispositivos(categoria, seguridad, sostenibilidad, ordenarSeleccionado);
        if (dispositivosMostrar != null) {
            dispositivosMostrados = dispositivosMostrar;
            view.showDispositivos(dispositivosMostrar);
        } else {
            view.showErrorServidor();
        }
    }


}
