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

    @Query("DELETE FROM dispositivos")
    void deleteAll();

    @Query("DELETE FROM dispositivos WHERE dispositivoId = :id")
    void eliminaDispositivo(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDispositivo(Dispositivo dispositivo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCaracteristica(Caracteristica caracteristica);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPositivaSeguridad(DispositivoCaracteristicaPositivaSeguridad positivaSeguridad);

    @Query("DELETE FROM dispositivo_caracteristica_positiva_seguridad where dispositivoId = :id")
    void eliminaPositivaSeguridad(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNegativaSeguridad(DispositivoCaracteristicaNegativaSeguridad negativaSeguridad);

    @Query("DELETE FROM dispositivo_caracteristica_negativa_seguridad where dispositivoId = :id")
    void eliminaNegativaSeguridad(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPositivaSostenibilidad(DispositivoCaracteristicaPositivaSostenibilidad positivaSostenibilidad);

    @Query("DELETE FROM dispositivo_caracteristica_positiva_sostenibilidad where dispositivoId = :id")
    void eliminaPositivaSostenibilidad(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNegativaSostenibilidad(DispositivoCaracteristicaNegativaSostenibilidad negativaSostenibilidad);

    @Query("DELETE FROM dispositivo_caracteristica_negativa_sostenibilidad where dispositivoId = :id")
    void eliminaNegativaSostenibilidad(String id);

}
