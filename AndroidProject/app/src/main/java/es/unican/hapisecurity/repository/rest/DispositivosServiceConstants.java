package es.unican.hapisecurity.repository.rest;

/**
 * Clase para definir la API_URL Base del servicio al que se quiere llamar
 */
public class DispositivosServiceConstants {

    private static final String SERVICIO_API_URL =
            "http://51.137.100.222:8080/";

    private static final String PRUEBAS_URL =
            "https://github.com/MarioIngelmo/TFG-MarioIngelmoDiana/tree/b2579809d7c1f70cb6076890732fcf9c586a8382/StaticREST/1/";

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
