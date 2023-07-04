package es.unican.hapisecurity.repository;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;

/**
 * Repositorio para acceder a los dispositivos
 */
public interface IDispositivosRepository {

    /**
     * Devuelve la lista de dispositivos que cumplan con los valores filtrados
     *
     * @param categoria           categoria que se quiere
     * @param seguridad           seguridad minima que se quiere
     * @param sostenibilidad      sostenibilidad minima que se quiere
     * @param ordenar             ordenamiento que se quiere
     * @return lista de los dispositivos filtrados, null si ocurre algo o no los hay
     */
    public List<Dispositivo> getDispositivos(String categoria, String seguridad, String sostenibilidad, String ordenar);

    /**
     * Devuelve el dispositivo al que corresponda el id
     * @param id id del dispositivo
     * @return dispositivo con id indicado
     */
    public  Dispositivo getDispositivoId(String id);

}
