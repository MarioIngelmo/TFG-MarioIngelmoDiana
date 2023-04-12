package es.unican.hapisecurity.common;

public class GlobalState {
    private static GlobalState instance = new GlobalState();
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

