package es.unican.hapisecurity.activities.favoritos;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public interface IFavoritosContract {

    interface View {

        /**
         * Metodo que se encargar de iniciar el fragment, resaltando el item correspondiente en el
         * menu lateral e indicando que se debe hacer cuando se pincha en un dispositivo de la lista
         */
        void init();

        IDispositivosRepository getRepositorioDispositivos();

        /**
         * Metodo para coger la lista de dispositivos obtenida, adaptarla y mostrarla
         * @param dispositivos dispositivos a mostrar
         */
        void showDispositivos(List<Dispositivo> dispositivos);

        /**
         * Metodo para iniciar el activity que muestre el dispositivo completo
         * @param dispositivo dispositivo a mostrar
         */
        void openDispositivoDetails(Dispositivo dispositivo);
    }

    interface Presenter {

        /**
         * Metodo que inicializa la lista de dispositivos a mostrar si no está vacía la base de datos
         */
        void init();

        /**
         * Metodo para indicar a la view cuál ha sido el dispositivo pulsado para abrir
         * @param index indice de la lista en el que se ha pulsado
         */
        void onDispositivoClicked(int index);
    }

}
