package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public interface IBuscadorContract {
    
    interface View {

        /**
         * Metodo que se encargar de iniciar el fragment, resaltando el item correspondiente en el
         * menu lateral e inicializando el boton de filtros y el buscador
         */
        void init();

        /**
         * Metodo para crear y mandarle al presenter un repositorio de dispositivos nuevo
         * @return el repositorio de dispositivos para poder hacer las llamadas
         */
        IDispositivosRepository getRepositorioDispositivos();

        /**
         * Metodo para cerrar el dialog de los filtros abierto
         * @param dialog dialog a cerrar
         */
        void cierraDialogo(AlertDialog dialog);

        /**
         * Metodo para almacenar los filtros seleccionados por el usuario
         *
         * @param categoriaTemporal           categoria seleccionada a guardar
         * @param valorSeguridadTemporal      seguridad seleccionada a guardar
         * @param valorSostenibilidadTemporal sostenibilidad seleccionada a guardar
         * @param ordenarTemporal             ordenamiento seleccionado a guardar
         */
        void guardaValorFiltros(String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal, String ordenarTemporal);

        /**
         * Metodo para coger la lista de dispositivos obtenida, adaptarla y mostrarla
         * @param dispositivos dispositivos a mostrar
         */
        void showDispositivos(List<Dispositivo> dispositivos);

        /**
         * Metodo para crear un toast que indique un error en la red
         */
        void showErrorRed();

        /**
         * Metodo para crear un toast que indique un error a la hora de cargar dispositivos
         */
        void showErrorServidor();

        /**
         * Metodo para iniciar el activity que muestre el dispositivo completo
         * @param dispositivo dispositivo a mostrar
         */
        void openDispositivoDetails(Dispositivo dispositivo);
    }
    
    interface Presenter {

        /**
         * Metodo que se encargar de iniciar el repositorio de dispositivos, comprobar si hay red
         * y obtener los dispositivos según los parámetros obtenidos
         * @param categoria categoria seleccionada que se quiere filtrar
         * @param seguridad seguridad seleccionada que se quiere filtrar
         * @param sostenibilidad sostenibilidad seleccionada que se quiere filtrar
         * @param ordenar ordenar seleccionado que se quiere usar
         */
        void init(String categoria, String seguridad, String sostenibilidad, String ordenar);

        /**
         * Metodo para indicar a la view que cierre el dialog porque no se aplican los filtros
         * @param dialog dialog a cerrar por la view
         */
        void cancelarFiltros(AlertDialog dialog);

        /**
         * Metodo para actualizar los filtros, si ningún filtro ha cambiado, solo se indica a la view
         * que cierre el dialog, sino se actualizan los valores indicándoselo a la view, se cargan
         * nuevos dispositivos y se indica a la view que cierre el dialog
         *
         * @param dialog                      dialog a cerrar
         * @param categoriaTemporal           categoria seleccionada
         * @param valorSeguridadTemporal      seguridad seleccionada
         * @param valorSostenibilidadTemporal sostenibilidad seleccionada
         * @param ordenarTemporal             ordenamiento seleccionado
         */
        void aplicarFiltros(AlertDialog dialog, String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal, String ordenarTemporal);

        /**
         * Metodo para indicar a la view cuál ha sido el dispositivo pulsado para abrir
         * @param index indice de la lista en el que se ha pulsado
         */
        void onDispositivoClicked(int index);

        /**
         * Metodo para filtrar los dispositivos con el texto del buscador
         * @param textoBuscar texto que se pone en el buscador
         */
        void filtraTexto(String textoBuscar);
    }
}
