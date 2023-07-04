package es.unican.hapisecurity.activities.dispositivo;

public interface IDispositivoContract {

    interface View {

        /**
         * Metodo que se encarga de inicializar la activity y de dar funcionalidad a la imagen
         * de la estrella (funciona como botón de favoritos)
         */
        void init();

        /**
         * Metodo para mostrar los datos del dispositivo
         * @param url url de donde conseguir la imagen
         * @param nombre nombre del dispositivo
         * @param marca marca del dispositivo
         * @param categoria categoria del dispositivo
         * @param precio precio del dispositivo
         * @param seguridad seguridad del dispositivo
         * @param sostenibilidad sostenibilidad del dispositivo
         * @param descripcion descripcion del dispositivo
         * @param posSeg string con los aspectos positivos de la seguridad del dispositivo
         * @param negSeg string con los aspectos negativos de la seguridad del dispositivo
         * @param posSost string con los aspectos positivos de la sostenibilidad del dispositivo
         * @param negSost string con los aspectos negativos de la sostenibilidad del dispositivo
         */
        void ponerDatosDispositivo(String url, String nombre, String marca, String categoria, String precio,
                                   String seguridad, String sostenibilidad, String descripcion, String posSeg,
                                   String negSeg, String posSost, String negSost);

        /**
         * Metodo que muestra la estrella sin marcar si el dispositivo no está en la base de datos
         */
        void noEstaDB();

        /**
         * Metodo que muestra la estrella marcada si el dispositivo está en la base de datos
         */
        void siEstaDB();
    }

    interface Presenter {

        /**
         * Metodo donde se inicializa el presenter y se consiguen todos los datos del dispositivo
         * y se mandan a la view
         */
        void init();

        /**
         * Metodo que se llama al pinchar sobre la estrella y añade o elimina el dispositivo
         * dependiendo de si está o no en la base de datos
         */
        void anhadeOEliminaFavoritos();
    }
}
