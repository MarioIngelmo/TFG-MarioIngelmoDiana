package es.unican.hapisecurity.repository.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import es.unican.hapisecurity.common.Caracteristica;

public class AdapterDB {

    @TypeConverter
    public static List<Caracteristica> convertirDesdeString(String stringConvertir) {
        Type listType = new TypeToken<List<Caracteristica>>() {}.getType();
        return new Gson().fromJson(stringConvertir, listType);
    }

    @TypeConverter
    public static String convertirDesdeLista(List<Caracteristica> listaConvertir) {
        Gson gson = new Gson();
        return gson.toJson(listaConvertir);
    }

}
