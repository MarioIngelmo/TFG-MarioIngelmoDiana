package es.unican.hapisecurity.activities.escanear;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public interface IEscanearContract {

    interface View {

        /**
         * Metodo que se encarga de solicitar los permisos y manejar la lectura del lector
         */
        void init();

        /**
         * Metodo para crear y mandarle al presenter un repositorio de dispositivos nuevo
         * @return el repositorio de dispositivos para poder hacer las llamadas
         */
        IDispositivosRepository getRepositorioDispositivos();

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
         * @param dispositivoMostrar dispositivo a mostrar
         */
        void openDispositivo(Dispositivo dispositivoMostrar);
    }

    interface Presenter {

        /**
         * Metodo que se encargar de iniciar el repositorio de dispositivos
         */
        void init();

        /**
         * Metodo que se encarga de comprobar que haya red y que obtiene el dispositivo cuyo codigo
         * ha sido escaneado
         * @param codigoBarras valor del codigo de barras escaneado
         */
        void getDispositivo(String codigoBarras);
    }
}
