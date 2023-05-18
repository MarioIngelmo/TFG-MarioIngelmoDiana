package es.unican.hapisecurity.repository.REST;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import es.unican.hapisecurity.common.DispositivosResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Clase para acceder a los dispositivos del servicio REST creado
 */
public class DispositivosService {

    private static final long TIMEOUT_SECONDS = 50L;

    private static DispositivosAPI api;

    private static String textoAPIURLAntiguo = null;
    private static String textoAPIURL = null;

    private DispositivosService() {}

    private static DispositivosAPI getAPI() {
        textoAPIURL = DispositivosServiceConstants.getAPIURL();
        if (api == null || !textoAPIURLAntiguo.equals(textoAPIURL)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DispositivosServiceConstants.getAPIURL())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(DispositivosAPI.class);
        }
        textoAPIURLAntiguo = DispositivosServiceConstants.getAPIURL();
        return api;
    }


    /**
     * Descarga todos los dispositivos en base a los tres query params que se pasan
     *
     * @param categoria      categoria de los dispositivos que se quieren
     * @param seguridad      seguridad minima que se quiere
     * @param sostenibilidad sostenibilidad minima que se quiere
     * @param ordenar        ordenamiento que se quiere
     * @return los dispositivos filtrados por las caracteristicas pasadas
     */
    public static DispositivosResponse getDispositivos(String categoria, String seguridad, String sostenibilidad, String ordenar) {
        final Call<DispositivosResponse> call = getAPI().dispositivos(categoria, seguridad, sostenibilidad, ordenar);
        return devolverResponse(call);
    }

    /**
     * Descarga el dispositivo en base al id solicitado
     * @param id id del dispositivo a descargar
     * @return el dispositivo con el id indicado
     */
    public static DispositivosResponse getDispositivoId(String id) {
        final Call<DispositivosResponse> call = getAPI().dispositivoPorId(id);
        return devolverResponse(call);
    }

    private static DispositivosResponse devolverResponse(Call<DispositivosResponse> call) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CallRunnable<DispositivosResponse> runnable = new CallRunnable<>(call);
        executor.execute(runnable);

        // wait until background task finishes
        executor.shutdown();
        try {
            executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // if there was some problem, response is null
        return runnable.response;
    }

}
