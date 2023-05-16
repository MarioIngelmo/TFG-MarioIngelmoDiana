package es.unican.hapisecurity.repository.REST;

public class DispositivosServiceConstants {

    private static final String MINECO_API_URL =
            "http://localhost:8080/";

    private DispositivosServiceConstants() {}

    private static String API_URL = MINECO_API_URL;

    public static void setMinecoURL() {
        API_URL = MINECO_API_URL;
    }

    public static final String getAPIURL() {
        return API_URL;
    }
}
