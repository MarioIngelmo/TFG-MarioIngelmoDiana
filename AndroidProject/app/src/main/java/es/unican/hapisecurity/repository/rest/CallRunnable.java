package es.unican.hapisecurity.repository.rest;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * This class wraps the synchronous request of a Retrofit call in a Runnable
 * Synchronous calls in Retrofit cannot be performed in the main thread, so a background thread
 * must be launched.
 * This background thread will execute this runnable.
 * @param <T> the type of the response
 */
class CallRunnable<T> implements Runnable {
    private final Call<T> call;
    public T response = null;

    CallRunnable(Call<T> call) {
        this.call = call;
    }

    @Override
    public void run() {
        try {
            Response<T> res = call.execute();
            this.response = res.body();
        } catch (IOException e) {
            Log.d("DEBUG", e.toString());
        }
    }
}