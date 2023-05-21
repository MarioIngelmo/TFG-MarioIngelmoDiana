package es.unican.hapisecurity.repository.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Dispositivo;

@Database(entities = {Dispositivo.class, Caracteristica.class}, version = 1, exportSchema = false)
@TypeConverters(AdapterDB.class)
public abstract class DispositivosDB extends RoomDatabase {

    public static final String NOMBRE_DB = "dispositivos_db";

    private static DispositivosDB db;

    public static DispositivosDB getDB(Context context) {
        if (db == null || !db.isOpen()) {
            db = Room
                    .databaseBuilder(context, DispositivosDB.class, DispositivosDB.NOMBRE_DB)
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

    public static void closeDB() {
        if (db!=null && db.isOpen())
            db.close();
    }

    public abstract IDispositivosDAO dispositivosDAO();
}
