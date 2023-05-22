package es.unican.hapisecurity.common;

/**
 * Clase global para almacenar el índice del objeto del menú lateral seleccionado
 */
public class GlobalState {
    private static final GlobalState instance = new GlobalState();
    private int mSelectedMenuIndex;

    private GlobalState() {
        // Constructor privado para evitar la creación de instancias
    }

    public static GlobalState getInstance() {
        return instance;
    }

    public int getSelectedMenuIndex() {
        return mSelectedMenuIndex;
    }

    public void setSelectedMenuIndex(int index) {
        mSelectedMenuIndex = index;
    }
}

