package es.unican.hapisecurity.activities.dispositivo;

public interface IDispositivoContract {

    interface View {

        void ponerDatosDispositivo(String url, String nombre, String marca, String categoria, String precio,
                                   String seguridad, String sostenibilidad, String descripcion, String posSeg,
                                   String negSeg, String posSost, String negSost);
    }

    interface Presenter {

        void init();
    }
}
