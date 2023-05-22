package es.unican.hapisecurity.activities.dispositivo;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.db.DispositivoCaracteristicaNegativaSeguridad;
import es.unican.hapisecurity.repository.db.DispositivoCaracteristicaNegativaSostenibilidad;
import es.unican.hapisecurity.repository.db.DispositivoCaracteristicaPositivaSeguridad;
import es.unican.hapisecurity.repository.db.DispositivoCaracteristicaPositivaSostenibilidad;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;

public class DispositivoPresenter implements IDispositivoContract.Presenter {

    private final Dispositivo dispositivo;
    private final IDispositivoContract.View view;
    private final IDispositivosDAO dao;

    public DispositivoPresenter(IDispositivoContract.View view, Dispositivo d, DispositivosDB db) {
        this.view = view;
        this.dispositivo = d;
        this.dao = db.dispositivosDAO();
    }

    @Override
    public void init() {
        String url = getUrl();
        String nombre = getNombre();
        String marca = getMarca();
        String categoria = getCategoria();
        String precio = getPrecio();
        String seguridad = getSeguridad();
        String sostenibilidad = getSostenibilidad();
        String descripcion = getDescripcion();
        String posSeg = getPosSeg();
        String negSeg = getNegSeg();
        String posSost = getPosSost();
        String negSost = getNegSost();

        this.compruebaDB();

        view.ponerDatosDispositivo(url, nombre, marca, categoria, precio, seguridad, sostenibilidad,
                descripcion, posSeg, negSeg, posSost, negSost);
    }

    @Override
    public void anhadeOEliminaFavoritos() {
        if (dao.getDispositivoById(dispositivo.getDispositivoId()) == null) {
            anhadeDB(dao, dispositivo);
            view.siEstaDB();
        } else {
            dao.eliminaDispositivo(dispositivo.getDispositivoId());
            view.noEstaDB();
        }
    }

    private void compruebaDB() {
        if (dao.getDispositivoById(dispositivo.getDispositivoId()) == null) {
            view.noEstaDB();
        } else {
            view.siEstaDB();
        }
    }

    private String getUrl() {
        String url = null;
        if (!dispositivo.getUrlImagen().isEmpty()) {
            url = dispositivo.getUrlImagen();
        }
        return url;
    }

    private String getNombre() {
        String nombre = "No hay nombre disponible";
        if (!dispositivo.getNombre().isEmpty()) {
            nombre = dispositivo.getNombre();
        }
        return nombre;
    }

    private String getMarca() {
        String marca = "No hay marca disponible";
        if (!dispositivo.getMarca().isEmpty()) {
            marca = dispositivo.getMarca();
        }
        return marca;
    }

    private String getCategoria() {
        String categoria = "No hay categoria disponible";
        if (dispositivo.getCategoria() != null) {
            String categoriaDispositivo = dispositivo.getCategoria().toString();
            if (categoriaDispositivo.equals("Asistente_Virtual")) {
                categoria = "Asistente Virtual";
            } else if (categoriaDispositivo.equals("Electrodomesticos_Inteligentes")) {
                categoria = "Electrodomesticos Inteligentes";
            } else {
                categoria = categoriaDispositivo;
            }
        }
        return categoria;
    }

    private String getPrecio() {
        String precio = "No hay precio disponible";
        if (!dispositivo.getPrecio().isEmpty()) {
            precio = dispositivo.getPrecio() + " €";
        }
        return precio;
    }

    private String getSeguridad() {
        String seguridad = "No hay seguridad disponible";
        if (!String.valueOf(dispositivo.getSeguridad()).isEmpty()) {
            seguridad = dispositivo.getSeguridad() + " / 100";
        }
        return seguridad;
    }

    private String getSostenibilidad() {
        String sostenibilidad = "No hay sostenibilidad disponible";
        if (!dispositivo.getSostenibilidad().isEmpty()) {
            sostenibilidad = dispositivo.getSostenibilidad();
        }
        return sostenibilidad;
    }

    private String getDescripcion() {
        String descripcion = "No hay descripcion disponible";
        if (!dispositivo.getDescripcion().isEmpty()) {
            descripcion = dispositivo.getDescripcion();
        }
        return descripcion;
    }

    private String getPosSeg() {
        String posSeg = "No hay caracteristicas positivas de seguridad";
        if (!dispositivo.getListaPositivaSeguridad().isEmpty()) {
            StringBuilder posSegTexto = new StringBuilder();
            for (Caracteristica c : dispositivo.getListaPositivaSeguridad()) {
                posSegTexto.append("\t- ").append(c.getTexto()).append("\n\n");
            }
            posSeg = posSegTexto.toString();
            int ultSalto = posSeg.lastIndexOf("\n");
            if (ultSalto != -1) {
                posSeg = posSeg.substring(0, ultSalto);
            }
        }
        return posSeg;
    }

    private String getNegSeg() {
        String negSeg = "No hay caracteristicas negativas de seguridad";
        if (!dispositivo.getListaNegativaSeguridad().isEmpty()) {
            StringBuilder negSegTexto = new StringBuilder();
            for (Caracteristica c : dispositivo.getListaNegativaSeguridad()) {
                negSegTexto.append("\t- ").append(c.getTexto()).append("\n\n");
            }
            negSeg = negSegTexto.toString();
            int ultSalto = negSeg.lastIndexOf("\n");
            if (ultSalto != -1) {
                negSeg = negSeg.substring(0, ultSalto);
            }
        }
        return negSeg;
    }

    private String getPosSost() {
        String posSost = "No hay caracteristicas positivas de sostenibilidad";
        if (!dispositivo.getListaPositivaSostenibilidad().isEmpty()) {
            StringBuilder posSostTexto = new StringBuilder();
            for (Caracteristica c : dispositivo.getListaPositivaSostenibilidad()) {
                posSostTexto.append("\t- ").append(c.getTexto()).append("\n\n");
            }
            posSost = posSostTexto.toString();
            int ultSalto = posSost.lastIndexOf("\n");
            if (ultSalto != -1) {
                posSost = posSost.substring(0, ultSalto);
            }
        }
        return posSost;
    }

    private String getNegSost() {
        String negSost = "No hay caracteristicas negativas de sostenibilidad";
        if (!dispositivo.getListaNegativaSostenibilidad().isEmpty()) {
            StringBuilder negSostTexto = new StringBuilder();
            for (Caracteristica c : dispositivo.getListaNegativaSostenibilidad()) {
                negSostTexto.append("\t- ").append(c.getTexto()).append("\n\n");
            }
            negSost = negSostTexto.toString();
            int ultSalto = negSost.lastIndexOf("\n");
            if (ultSalto != -1) {
                negSost = negSost.substring(0, ultSalto);
            }
        }
        return negSost;
    }

    private void anhadeDB(IDispositivosDAO dao, Dispositivo dispositivo) {
        dao.insertDispositivo(dispositivo);
        for (Caracteristica c: dispositivo.getListaPositivaSeguridad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaPositivaSeguridad carac = new DispositivoCaracteristicaPositivaSeguridad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertPositivaSeguridad(carac);
        }
        for (Caracteristica c: dispositivo.getListaNegativaSeguridad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaNegativaSeguridad carac = new DispositivoCaracteristicaNegativaSeguridad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertNegativaSeguridad(carac);
        }
        for (Caracteristica c: dispositivo.getListaPositivaSostenibilidad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaPositivaSostenibilidad carac = new DispositivoCaracteristicaPositivaSostenibilidad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertPositivaSostenibilidad(carac);
        }
        for (Caracteristica c: dispositivo.getListaNegativaSostenibilidad()) {
            dao.insertCaracteristica(c);
            DispositivoCaracteristicaNegativaSostenibilidad carac = new DispositivoCaracteristicaNegativaSostenibilidad();
            carac.setDispositivoId(dispositivo.getDispositivoId());
            carac.setCaracteristicaId(c.getCaracteristicaId());
            dao.insertNegativaSostenibilidad(carac);
        }
    }

}
