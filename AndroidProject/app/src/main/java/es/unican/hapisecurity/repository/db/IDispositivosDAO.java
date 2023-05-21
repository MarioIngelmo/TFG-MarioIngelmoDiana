package es.unican.hapisecurity.repository.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;

@Dao
public interface IDispositivosDAO {

    @Query("SELECT * FROM dispositivos")
    List<Dispositivo> getAll();

    @Query("SELECT * FROM dispositivos where dispositivos.id = :id")
    Dispositivo getDispositivoById(String id);

    @Query("DELETE FROM dispositivos WHERE id = :id")
    void eliminaDispositivo(String id);

    @Insert
    void insertAll(Dispositivo... dispositivos);

}
