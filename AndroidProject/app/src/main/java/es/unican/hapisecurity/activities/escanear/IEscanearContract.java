package es.unican.hapisecurity.activities.escanear;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public interface IEscanearContract {

    interface View {

        void init();

        IDispositivosRepository getRepositorioDispositivos();

        void showErrorRed();

        void showErrorServidor();

        void openDispositivo(Dispositivo dispositivoMostrar);
    }

    interface Presenter {

        void init();

        void getDispositivo(String codigoBarras);
    }
}
