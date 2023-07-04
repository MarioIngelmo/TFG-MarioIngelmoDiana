package es.unican.hapisecurity.repository.rest;

import es.unican.hapisecurity.common.Callback;
import retrofit2.Call;
import retrofit2.Response;

/**
 * This class adapts a Retrofit Callback into our own Callback class
 * @param <T>
 */
class CallbackAdapter<T> implements retrofit2.Callback<T> {
    private final Callback<T> cb;

    public CallbackAdapter(Callback<T> cb) {
        this.cb = cb;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        cb.onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        cb.onFailure();
    }
}