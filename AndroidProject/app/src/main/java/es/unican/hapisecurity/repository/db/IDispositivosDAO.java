package es.unican.hapisecurity.repository.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Dispositivo;

@Dao
public interface IDispositivosDAO {

    @Transaction
    @Query("SELECT * FROM dispositivos")
    List<DispositivoConCaracteristicas> getAll();

    @Transaction
    @Query("SELECT * FROM dispositivos where dispositivos.dispositivoId = :id")
    DispositivoConCaracteristicas getDispositivoById(String id);

    @Query("DELETE FROM dispositivos WHERE dispositivoId = :id")
    void eliminaDispositivo(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDispositivo(Dispositivo dispositivo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCaracteristica(Caracteristica caracteristica);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPositivaSeguridad(DispositivoCaracteristicaPositivaSeguridad positivaSeguridad);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNegativaSeguridad(DispositivoCaracteristicaNegativaSeguridad negativaSeguridad);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPositivaSostenibilidad(DispositivoCaracteristicaPositivaSostenibilidad positivaSostenibilidad);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNegativaSostenibilidad(DispositivoCaracteristicaNegativaSostenibilidad negativaSostenibilidad);

}
