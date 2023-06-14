package es.unican.hapisecurity.activities.favoritos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.os.Build;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.LinkedList;
import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.IDispositivosRepository;
import es.unican.hapisecurity.repository.db.DispositivoConCaracteristicas;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class FavoritosPresenterTest {

    private static IDispositivosRepository repositorio;
    private static IFavoritosContract.View view;
    private static IFavoritosContract.Presenter presenter;
    private IDispositivosDAO dao;

    @Before
    public void inicializa() {
        view = mock(IFavoritosContract.View.class);
        repositorio = mock(IDispositivosRepository.class);
        DispositivosDB db = mock(DispositivosDB.class);
        dao = mock(IDispositivosDAO.class);

        when(db.dispositivosDAO()).thenReturn(dao);
        when(view.getRepositorioDispositivos()).thenReturn(repositorio);
        presenter = new FavoritosPresenter(view, db, true);
    }

    /**
     * Test para comprobar que funciona correctamente favoritos con la lista vacia, con un dispositivo
     * y con varios
     */
    @Test
    public void inicializaFavoritosTest() {
        LinkedList<DispositivoConCaracteristicas> dispositivosRepositorioVacio = new LinkedList<>();
        LinkedList<DispositivoConCaracteristicas> dispositivosRepositorioUnDispositivo = new LinkedList<>();
        LinkedList<DispositivoConCaracteristicas> dispositivosRepositorio = new LinkedList<>();
        DispositivoConCaracteristicas d1 = new DispositivoConCaracteristicas();
        DispositivoConCaracteristicas d2 = new DispositivoConCaracteristicas();
        DispositivoConCaracteristicas d3 = new DispositivoConCaracteristicas();
        DispositivoConCaracteristicas d4 = new DispositivoConCaracteristicas();

        d1.setDispositivo(new Dispositivo());
        d2.setDispositivo(new Dispositivo());
        d3.setDispositivo(new Dispositivo());
        d4.setDispositivo(new Dispositivo());
        d1.getDispositivo().setDispositivoId("123");
        d1.getDispositivo().setNombre("Nombre Test 1");
        d1.getDispositivo().setMarca("Marca Test 1");
        d1.getDispositivo().setSeguridad(50);
        d1.getDispositivo().setSostenibilidad("A");
        d2.getDispositivo().setDispositivoId("1234");
        d2.getDispositivo().setNombre("Nombre Test 2");
        d2.getDispositivo().setMarca("Marca Test 2");
        d2.getDispositivo().setSeguridad(92);
        d2.getDispositivo().setSostenibilidad("B");
        d3.getDispositivo().setDispositivoId("1235");
        d3.getDispositivo().setNombre("Nombre Test 3");
        d3.getDispositivo().setMarca("Marca Test 3");
        d3.getDispositivo().setSeguridad(60);
        d3.getDispositivo().setSostenibilidad("C");
        d4.getDispositivo().setDispositivoId("1236");
        d4.getDispositivo().setNombre("Nombre Test 4");
        d4.getDispositivo().setMarca("Marca Test 4");
        d4.getDispositivo().setSeguridad(75);
        d4.getDispositivo().setSostenibilidad("D");

        dispositivosRepositorioUnDispositivo.add(d1);

        dispositivosRepositorio.add(d1);
        dispositivosRepositorio.add(d2);
        dispositivosRepositorio.add(d3);
        dispositivosRepositorio.add(d4);

        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);

        // Primero probamos con la lista de favoritos vacia
        when(dao.getAll()).thenReturn(dispositivosRepositorioVacio);
        presenter.init();
        verify(view, times(1)).getRepositorioDispositivos();
        verify(view, times(1)).showDispositivos(lista.capture());
        assertTrue(lista.getValue().isEmpty());

        // Segundo probamos con un solo dispositivo
        when(dao.getAll()).thenReturn(dispositivosRepositorioUnDispositivo);
        presenter.init();
        verify(view, times(2)).showDispositivos(lista.capture());
        assertEquals(1, lista.getValue().size());
        Dispositivo d = lista.getValue().get(0);
        assertEquals("123", d.getDispositivoId());
        assertEquals("Nombre Test 1", d.getNombre());
        assertEquals("Marca Test 1", d.getMarca());
        assertEquals(50, d.getSeguridad());
        assertEquals("A", d.getSostenibilidad());

        // Por ultimo probamos con todos los dispositivos
        when(dao.getAll()).thenReturn(dispositivosRepositorio);
        presenter.init();
        verify(view, times(3)).showDispositivos(lista.capture());
        assertEquals(4, lista.getValue().size());
        // Aqui solo comprobamos que los valores no sean nulos
        for (Dispositivo disp: lista.getValue()) {
            assertFalse(disp.getDispositivoId().isEmpty());
            assertFalse(disp.getNombre().isEmpty());
            assertFalse(disp.getMarca().isEmpty());
            assertNotEquals(0, disp.getSeguridad());
            assertFalse(disp.getSostenibilidad().isEmpty());
        }

        dao.deleteAll();
    }

    /**
     * Test para comprobar que se actualiza el dispositivo en favoritos
     */
    @Test
    public void actualizaFavoritosTest() {
        LinkedList<DispositivoConCaracteristicas> dispositivosRepositorio = new LinkedList<>();
        DispositivoConCaracteristicas d1 = new DispositivoConCaracteristicas();
        d1.setDispositivo(new Dispositivo());
        d1.getDispositivo().setDispositivoId("123");
        d1.getDispositivo().setNombre("Nombre Test 1");
        d1.getDispositivo().setMarca("Marca Test 1");
        d1.getDispositivo().setSeguridad(50);
        d1.getDispositivo().setSostenibilidad("A");

        dispositivosRepositorio.add(d1);

        Dispositivo d2 = new Dispositivo();
        d2.setDispositivoId("123");
        d2.setNombre("Nombre Test 2");
        d2.setMarca("Marca Test 2");
        d2.setSeguridad(92);
        d2.setSostenibilidad("B");
        // Añadimos listas vacias para que no salte error
        d2.setListaPositivaSeguridad(new LinkedList<>());
        d2.setListaNegativaSeguridad(new LinkedList<>());
        d2.setListaPositivaSostenibilidad(new LinkedList<>());
        d2.setListaNegativaSostenibilidad(new LinkedList<>());

        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);

        // Comprobamos que aunque añadamos el dispositivo con nombre test 1, se actualiza al dispositivo 2
        when(dao.getAll()).thenReturn(dispositivosRepositorio);
        when(repositorio.getDispositivoId("123")).thenReturn(d2);
        presenter.init();
        verify(view, times(1)).getRepositorioDispositivos();
        verify(view, times(1)).showDispositivos(lista.capture());
        assertEquals(1, lista.getValue().size());
        Dispositivo d = lista.getValue().get(0);
        assertEquals("123", d.getDispositivoId());
        assertEquals("Nombre Test 2", d.getNombre());
        assertEquals("Marca Test 2", d.getMarca());
        assertEquals(92, d.getSeguridad());
        assertEquals("B", d.getSostenibilidad());

        dao.deleteAll();
    }

}
