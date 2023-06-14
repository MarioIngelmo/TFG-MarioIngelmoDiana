package es.unican.hapisecurity.activities.dispositivo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.LinkedList;

import es.unican.hapisecurity.common.Caracteristica;
import es.unican.hapisecurity.common.Categoria;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class DispositivoPresenterTest {

    private static IDispositivoContract.View view;
    private static IDispositivoContract.Presenter presenter;
    private static DispositivosDB db;
    private static IDispositivosDAO dao;
    private Dispositivo d1, d2;
    private Caracteristica c1, c2, c3, c4;

    @Before
    public void inicializa() {
        db = mock(DispositivosDB.class);
        dao = mock(IDispositivosDAO.class);
        view = mock(IDispositivoContract.View.class);
        d1 = mock(Dispositivo.class);
        d2 = mock(Dispositivo.class);
        c1 = mock(Caracteristica.class);
        c2 = mock(Caracteristica.class);
        c3 = mock(Caracteristica.class);
        c4 = mock(Caracteristica.class);
    }

    /**
     * Test donde se prueba a inicializar el presenter con un dispositivo cuyos datos esten vacios
     */
    @Test
    public void initDispositivoPresenterVacioTest() {
        when(db.dispositivosDAO()).thenReturn(dao);

        when(d1.getDispositivoId()).thenReturn("");
        when(d1.getUrlImagen()).thenReturn("");
        when(d1.getNombre()).thenReturn("");
        when(d1.getMarca()).thenReturn("");
        when(d1.getDescripcion()).thenReturn("");
        when(d1.getCategoria()).thenReturn(null);
        when(d1.getPrecio()).thenReturn("");
        when(d1.getSeguridad()).thenReturn(0);
        when(d1.getSostenibilidad()).thenReturn("");
        when(d1.getListaPositivaSeguridad()).thenReturn(new LinkedList<>());
        when(d1.getListaNegativaSeguridad()).thenReturn(new LinkedList<>());
        when(d1.getListaPositivaSostenibilidad()).thenReturn(new LinkedList<>());
        when(d1.getListaNegativaSostenibilidad()).thenReturn(new LinkedList<>());

        presenter = new DispositivoPresenter(view, d1, db);
        presenter.init();

        verify(d1, times(1)).getUrlImagen();
        verify(d1, times(1)).getNombre();
        verify(d1, times(1)).getMarca();
        verify(d1, times(1)).getDescripcion();
        verify(d1, times(1)).getCategoria();
        verify(d1, times(1)).getPrecio();
        verify(d1, times(2)).getSeguridad();
        verify(d1, times(1)).getSostenibilidad();
        verify(d1, times(1)).getListaPositivaSeguridad();
        verify(d1, times(1)).getListaNegativaSeguridad();
        verify(d1, times(1)).getListaPositivaSostenibilidad();
        verify(d1, times(1)).getListaNegativaSostenibilidad();

        verify(view, times(1)).ponerDatosDispositivo(null, "No hay nombre disponible",
                "No hay marca disponible", "No hay categoria disponible", "No hay precio disponible",
                "0 / 100", "No hay sostenibilidad disponible", "No hay descripcion disponible",
                "No hay caracteristicas positivas de seguridad", "No hay caracteristicas negativas de seguridad",
                "No hay caracteristicas positivas de sostenibilidad", "No hay caracteristicas negativas de sostenibilidad");
    }

    /**
     * Test donde se prueba a inicializar el presenter con un dispositivo con datos
     */
    @Test
    public void initDispositivoPresenterTest() {
        when(db.dispositivosDAO()).thenReturn(dao);

        when(c1.getTexto()).thenReturn("Caracteristica 1");
        when(c2.getTexto()).thenReturn("Caracteristica 2");
        when(c3.getTexto()).thenReturn("Caracteristica 3");
        when(c4.getTexto()).thenReturn("Caracteristica 4");

        LinkedList<Caracteristica> lista1 = new LinkedList<>();
        lista1.add(c1);
        LinkedList<Caracteristica> lista2 = new LinkedList<>();
        lista2.add(c2);
        LinkedList<Caracteristica> lista3 = new LinkedList<>();
        lista3.add(c3);
        LinkedList<Caracteristica> lista4 = new LinkedList<>();
        lista4.add(c4);

        when(d2.getDispositivoId()).thenReturn("54326534");
        when(d2.getUrlImagen()).thenReturn("http://www.aaa.es");
        when(d2.getNombre()).thenReturn("Dispositivo Test");
        when(d2.getMarca()).thenReturn("Test");
        when(d2.getDescripcion()).thenReturn("Descripcion Test");
        when(d2.getCategoria()).thenReturn(Categoria.Climatizacion);
        when(d2.getPrecio()).thenReturn("100");
        when(d2.getSeguridad()).thenReturn(90);
        when(d2.getSostenibilidad()).thenReturn("A");
        when(d2.getListaPositivaSeguridad()).thenReturn(lista1);
        when(d2.getListaNegativaSeguridad()).thenReturn(lista2);
        when(d2.getListaPositivaSostenibilidad()).thenReturn(lista3);
        when(d2.getListaNegativaSostenibilidad()).thenReturn(lista4);

        presenter = new DispositivoPresenter(view, d2, db);
        presenter.init();

        verify(d2, times(2)).getUrlImagen();
        verify(d2, times(2)).getNombre();
        verify(d2, times(2)).getMarca();
        verify(d2, times(2)).getDescripcion();
        verify(d2, times(2)).getCategoria();
        verify(d2, times(2)).getPrecio();
        verify(d2, times(2)).getSeguridad();
        verify(d2, times(2)).getSostenibilidad();
        verify(d2, times(2)).getListaPositivaSeguridad();
        verify(d2, times(2)).getListaNegativaSeguridad();
        verify(d2, times(2)).getListaPositivaSostenibilidad();
        verify(d2, times(2)).getListaNegativaSostenibilidad();

        verify(view, times(1)).ponerDatosDispositivo("http://www.aaa.es", "Dispositivo Test",
                "Test", "Climatizacion", "100 €", "90 / 100", "A", "Descripcion Test",
                "\t- Caracteristica 1\n", "\t- Caracteristica 2\n", "\t- Caracteristica 3\n",
                "\t- Caracteristica 4\n");
    }

}
