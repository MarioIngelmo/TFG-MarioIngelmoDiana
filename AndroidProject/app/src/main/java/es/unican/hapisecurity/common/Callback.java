package es.unican.hapisecurity.common;

/**
 * Our custom Callback class
 * This is used in asynchronous calls to the repository
 * It may be used elsewhere if needed
 * @param <T> the type of data
 */
public interface Callback<T> {

    /**
     * This method is called when the data is successfully fetched
     * @param data the data fetched
     */
    void onSuccess(T data);

    /**
     * This method is called when a failure occurred
     */
    void onFailure();

}
