package es.unican.hapisecurity.repository.REST;

/**
 * Clase para definir la API_URL Base del servicio al que se quiere llamar
 */
public class DispositivosServiceConstants {

    private static final String SERVICIO_API_URL =
            "http://localhost:8080/";

    private DispositivosServiceConstants() {}

    private static String API_URL = SERVICIO_API_URL;

    public static void setMinecoURL() {
        API_URL = SERVICIO_API_URL;
    }

    public static final String getAPIURL() {
        return API_URL;
    }
}
