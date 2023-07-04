package es.unican.hapisecurity.repository.rest;

import es.unican.hapisecurity.common.DispositivosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Dispositivos API access using Retrofit
 * Se utiliza Retrofit para la conexion con el servicio REST desarrollado
 */
public interface DispositivosAPI {

    @GET("REST_TFGMarioIngelmoDiana/dispositivos")
    Call<DispositivosResponse> dispositivos(@Query("categoria") String categoria, @Query("seguridad")
        String seguridad, @Query("sostenibilidad") String sostenibilidad, @Query("ordenar") String ordenar);


    @GET("REST_TFGMarioIngelmoDiana/dispositivos/{id}")
    Call<DispositivosResponse> dispositivoPorId(@Path("id") String id);

}
