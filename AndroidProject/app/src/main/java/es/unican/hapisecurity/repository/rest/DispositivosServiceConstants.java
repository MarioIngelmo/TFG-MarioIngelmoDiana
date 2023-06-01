package es.unican.hapisecurity.repository.rest;

/**
 * Clase para definir la API_URL Base del servicio al que se quiere llamar
 */
public class DispositivosServiceConstants {

    private static final String SERVICIO_API_URL =
            "http://51.137.100.222:8080/";

    private static final String PRUEBAS_URL =
            "https://github.com/MarioIngelmo/TFG-MarioIngelmoDiana/tree/c060abe4140c692e0fa9341d6d93eb29d850f7b1/StaticREST/";

    private DispositivosServiceConstants() {}

    private static String API_URL = SERVICIO_API_URL;

    public static void setApiUrl() {
        API_URL = SERVICIO_API_URL;
    }

    public static void setPruebasUrl() {
        API_URL = PRUEBAS_URL;
    }

    public static final String getAPIURL() {
        return API_URL;
    }
}
