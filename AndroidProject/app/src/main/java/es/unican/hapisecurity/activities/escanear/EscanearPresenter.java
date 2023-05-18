package es.unican.hapisecurity.activities.escanear;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public class EscanearPresenter implements IEscanearContract.Presenter {

    private final IEscanearContract.View view;
    private IDispositivosRepository repositorioDispositivos;
    private final Boolean red;


    public EscanearPresenter(IEscanearContract.View view, Boolean red) {
        this.view = view;
        this.red = red;
        this.init();
    }

    @Override
    public void init() {
        if (repositorioDispositivos == null) {
            repositorioDispositivos = view.getRepositorioDispositivos();
        }
    }

    @Override
    public void getDispositivo(String codigoBarras) {
        if (repositorioDispositivos != null) {
            if (Boolean.TRUE.equals(red)) {
                obtenDispositivo(codigoBarras);
            } else {
                view.showErrorRed();
            }
        }
    }

    private void obtenDispositivo(String id) {
        Dispositivo dispositivoMostrar = repositorioDispositivos.getDispositivoId(id);
        if (dispositivoMostrar != null) {
            view.openDispositivo(dispositivoMostrar);
        } else {
            view.showErrorServidor();
        }
    }

}
