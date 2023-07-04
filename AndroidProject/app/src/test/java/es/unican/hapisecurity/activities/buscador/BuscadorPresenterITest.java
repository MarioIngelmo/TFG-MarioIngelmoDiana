package es.unican.hapisecurity.activities.buscador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.DispositivosRepository;
import es.unican.hapisecurity.repository.IDispositivosRepository;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class BuscadorPresenterITest {

    private static IBuscadorContract.View view;
    private static IBuscadorContract.Presenter presenter;

    @Before
    public void inicializa() {
        Context context = ApplicationProvider.getApplicationContext();
        IDispositivosRepository repositorio = new DispositivosRepository(context);

        view = mock(IBuscadorContract.View.class);
        when(view.getRepositorioDispositivos()).thenReturn(repositorio);
    }

    @BeforeClass
    public static void setUp() {
        DispositivosServiceConstants.setPruebasUrl();
    }

    @AfterClass
    public static void clean() {
        DispositivosServiceConstants.setApiUrl();
    }

    /**
     * Test donde se comprueba que la lista se muestra correctamente
     */
    @Test
    public void inicializaListaTest() {
        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);
        presenter = new BuscadorPresenter(view, "Todas", "0", "G", "Alfabetico", true);
        verify(view, times(1)).showDispositivos(lista.capture());
        assertEquals(21, lista.getValue().size());
        for (Dispositivo d: lista.getValue()) {
            assertFalse(d.getNombre().isEmpty());
            assertFalse(d.getMarca().isEmpty());
            assertNotEquals(0, d.getSeguridad());
            assertFalse(d.getSostenibilidad().isEmpty());
        }
    }

    /**
     * Test donde se comprueba que el buscador funciona y la lista se reduce
     */
    @Test
    public void buscadorFiltraListaTest() {
        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);
        presenter = new BuscadorPresenter(view, "Todas", "0", "G", "Alfabetico", true);
        verify(view, times(1)).showDispositivos(lista.capture());
        assertEquals(21, lista.getValue().size());

        presenter.filtraTexto("Apple");
        verify(view, times(2)).showDispositivos(lista.capture());
        assertEquals(2, lista.getValue().size());

        Dispositivo d1 = lista.getValue().get(0);
        assertEquals("Apple HomePod", d1.getNombre());
        assertEquals("Apple", d1.getMarca());
        assertEquals(80, d1.getSeguridad());
        assertEquals("A", d1.getSostenibilidad());

        Dispositivo d2 = lista.getValue().get(1);
        assertEquals("Apple HomePod Mini", d2.getNombre());
        assertEquals("Apple", d2.getMarca());
        assertEquals(60, d2.getSeguridad());
        assertEquals("C", d2.getSostenibilidad());
    }

    /**
     * Test donde se comprueba que el buscador funciona y la lista se queda vacia al no haber coincidencia
     */
    @Test
    public void buscadorFiltraListaVaciaTest() {
        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);
        presenter = new BuscadorPresenter(view, "Todas", "0", "G", "Alfabetico", true);
        verify(view, times(1)).showDispositivos(lista.capture());
        assertEquals(21, lista.getValue().size());

        presenter.filtraTexto("Test");
        verify(view, times(2)).showDispositivos(lista.capture());
        assertEquals(0, lista.getValue().size());
    }

}
