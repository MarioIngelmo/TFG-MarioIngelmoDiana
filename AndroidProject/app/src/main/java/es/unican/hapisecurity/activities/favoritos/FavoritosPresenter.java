package es.unican.hapisecurity.activities.favoritos;

import java.util.LinkedList;
import java.util.List;

import es.unican.hapisecurity.repository.db.AuxiliarDB;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;
import es.unican.hapisecurity.repository.db.DispositivoConCaracteristicas;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;

public class FavoritosPresenter implements IFavoritosContract.Presenter {

    private final IFavoritosContract.View view;
    private final IDispositivosDAO dao;
    private final Boolean red;
    private IDispositivosRepository repositorioDispositivos;
    private List<Dispositivo> dispositivosMostrados = new LinkedList<>();

    public FavoritosPresenter(IFavoritosContract.View view, DispositivosDB db, Boolean red) {
        this.view = view;
        this.dao = db.dispositivosDAO();
        this.red = red;
    }

    @Override
    public void init() {
        if (dao.getAll() == null) {
            view.showDispositivos(dispositivosMostrados);
        } else {
            List<DispositivoConCaracteristicas> dispositivosDB = dao.getAll();
            if (Boolean.TRUE.equals(red)) {
                if (repositorioDispositivos == null) {
                    repositorioDispositivos = view.getRepositorioDispositivos();
                }
                dispositivosMostrados = actualizaDatosDispositivos(dispositivosDB);
            } else {
                dispositivosMostrados = adaptaDispositivosCaracteristicas(dispositivosDB);
            }
            view.showDispositivos(dispositivosMostrados);
        }
    }

    @Override
    public void onDispositivoClicked(int index) {
        if (dispositivosMostrados != null && index < dispositivosMostrados.size()) {
            Dispositivo dispositivo = dispositivosMostrados.get(index);
            view.openDispositivoDetails(dispositivo);
        }
    }

    /**
     * Metodo para actualizar los dispositivos de la base de datos que se encuentren en el repositorio
     * @param dispositivosDB la lista de dispositivos en la base de datos
     * @return lista con los dispositivos actualizados y convertidos para mostrar
     */
    private List<Dispositivo> actualizaDatosDispositivos(List<DispositivoConCaracteristicas> dispositivosDB) {
        List<Dispositivo> listaDevolver = new LinkedList<>();
        List<DispositivoConCaracteristicas> listaNoEstanRepositorio = new LinkedList<>();

        for (DispositivoConCaracteristicas d : dispositivosDB) {
            Dispositivo dispositivo = repositorioDispositivos.getDispositivoId(d.getDispositivo().getDispositivoId());
            // Compruebo si se ha podido traer el dispositivo actualizado del repositorio,
            // sino se añade a otra lista para añadirlo sin actualizar posteriormente
            if (dispositivo != null) {
                AuxiliarDB.eliminaDB(dao, dispositivo.getDispositivoId());
                AuxiliarDB.anhadeDB(dao, dispositivo);
                listaDevolver.add(dispositivo);
            } else {
                listaNoEstanRepositorio.add(d);
            }
        }
        // Si algún dispositivo no ha podido actualizarse, lo convierto y lo añado a la lista a mostrar
        if (!listaNoEstanRepositorio.isEmpty()) {
            List<Dispositivo> listaAnhadirADevolver = adaptaDispositivosCaracteristicas(listaNoEstanRepositorio);
            listaDevolver.addAll(listaAnhadirADevolver);
        }

        return listaDevolver;
    }

    /**
     * Metodo que convierte la lista de dispositivos de la base de datos en dispositivos que se puedan mostrar
     * @param dispositivosDB la lista de dispositivos en la base de datos
     * @return lista con los dispositivos convertidos para mostrar
     */
    private List<Dispositivo> adaptaDispositivosCaracteristicas(List<DispositivoConCaracteristicas> dispositivosDB) {
        List<Dispositivo> listaDevolver = new LinkedList<>();

        // Recorro la lista de dispositivos de la base de datos convirtiéndolos en dispositivos que se puedan mostrar
        for (DispositivoConCaracteristicas d: dispositivosDB) {

            Dispositivo dGuardado = d.getDispositivo();
            Dispositivo dispositivoAnhadir = new Dispositivo();

            dispositivoAnhadir.setDispositivoId(dGuardado.getDispositivoId());
            dispositivoAnhadir.setUrlImagen(dGuardado.getUrlImagen());
            dispositivoAnhadir.setNombre(dGuardado.getNombre());
            dispositivoAnhadir.setMarca(dGuardado.getMarca());
            dispositivoAnhadir.setDescripcion(dGuardado.getDescripcion());
            dispositivoAnhadir.setCategoria(dGuardado.getCategoria());
            dispositivoAnhadir.setPrecio(dGuardado.getPrecio());
            dispositivoAnhadir.setSeguridad(dGuardado.getSeguridad());
            dispositivoAnhadir.setSostenibilidad(dGuardado.getSostenibilidad());
            dispositivoAnhadir.setListaPositivaSeguridad(d.getPositivasSeguridad());
            dispositivoAnhadir.setListaNegativaSeguridad(d.getNegativasSeguridad());
            dispositivoAnhadir.setListaPositivaSostenibilidad(d.getPositivasSostenibilidad());
            dispositivoAnhadir.setListaNegativaSostenibilidad(d.getNegativasSostenibilidad());

            listaDevolver.add(dispositivoAnhadir);
        }
        return listaDevolver;
    }

}
