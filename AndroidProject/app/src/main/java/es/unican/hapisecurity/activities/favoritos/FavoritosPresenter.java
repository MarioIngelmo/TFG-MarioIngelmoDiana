package es.unican.hapisecurity.activities.favoritos;

import java.util.LinkedList;
import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.db.DispositivoConCaracteristicas;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;

public class FavoritosPresenter implements IFavoritosContract.Presenter {

    private final IFavoritosContract.View view;
    private final IDispositivosDAO dao;
    private final Boolean red;
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
            dispositivosMostrados = adaptaDispositivosCaracteristicas(dispositivosDB);
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

    private List<Dispositivo> adaptaDispositivosCaracteristicas(List<DispositivoConCaracteristicas> dispositivosDB) {
        List<Dispositivo> listaDevolver = new LinkedList<>();

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
