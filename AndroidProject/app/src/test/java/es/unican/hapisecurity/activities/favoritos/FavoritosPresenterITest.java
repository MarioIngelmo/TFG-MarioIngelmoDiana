package es.unican.hapisecurity.activities.favoritos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import es.unican.hapisecurity.common.Categoria;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.DispositivosRepository;
import es.unican.hapisecurity.repository.IDispositivosRepository;
import es.unican.hapisecurity.repository.db.DispositivosDB;
import es.unican.hapisecurity.repository.db.IDispositivosDAO;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class FavoritosPresenterITest {

    private static final String ID = "3534265265";
    private static final String URL = "https://www.bombillaTest.es";
    private static final String NOMBRE = "Bombilla Test";
    private static final String MARCA = "Test";
    private static final String DESCRIPCION = "Bombilla para el test del dispositivo";
    private static final Categoria CATEGORIA = Categoria.Iluminacion;
    private static final String PRECIO = "135";
    private static final int SEGURIDAD = 95;
    private static final String SOSTENIBILIDAD = "A";

    private static IFavoritosContract.View view;
    private static IFavoritosContract.Presenter presenter;
    private DispositivosDB db;

    @Before
    public void inicializa() {
        Context context = ApplicationProvider.getApplicationContext();
        IDispositivosRepository repositorio = new DispositivosRepository(context);
        db = DispositivosDB.getDB(context);

        view = mock(IFavoritosContract.View.class);
        when(view.getRepositorioDispositivos()).thenReturn(repositorio);
        presenter = new FavoritosPresenter(view, db, true);
    }

    @After
    public void cierra() {
        DispositivosDB.closeDB();
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
     * Test para comprobar que la lista al principio está vacía y que se añade correctamente
     * el dispositivo después y que al clicar en él funciona el click
     */
    @Test
    public void inicializaFavoritosITest() {
        ArgumentCaptor<List<Dispositivo>> lista = ArgumentCaptor.forClass(List.class);
        IDispositivosDAO dao = db.dispositivosDAO();
        dao.deleteAll();

        // Se crea un dispositivo
        Dispositivo d = new Dispositivo();
        d.setDispositivoId(ID);
        d.setUrlImagen(URL);
        d.setNombre(NOMBRE);
        d.setMarca(MARCA);
        d.setDescripcion(DESCRIPCION);
        d.setCategoria(CATEGORIA);
        d.setPrecio(PRECIO);
        d.setSeguridad(SEGURIDAD);
        d.setSostenibilidad(SOSTENIBILIDAD);

        // Probamos que se muestra el texto al estar vacia
        presenter.init();
        verify(view, times(1)).showDispositivos(lista.capture());
        assertTrue(lista.getValue().isEmpty());

        // Comprobamos que no se hace click al estar la lista vacia
        presenter.onDispositivoClicked(0);
        verify(view, times(0)).openDispositivoDetails(d);

        // Añadimos el dispositivo
        dao.insertDispositivo(d);

        // Comprobamos que se ha añadido y aparece correctamente
        presenter.init();
        verify(view, times(2)).showDispositivos(lista.capture());
        assertEquals(1, lista.getValue().size());
        Dispositivo comprobar = lista.getValue().get(0);
        assertEquals(ID, comprobar.getDispositivoId());
        assertEquals(NOMBRE, comprobar.getNombre());
        assertEquals(MARCA, comprobar.getMarca());
        assertEquals(SEGURIDAD, comprobar.getSeguridad());
        assertEquals(SOSTENIBILIDAD, comprobar.getSostenibilidad());

        // Comprobamos que se pueda clicar sobre el mismo
        presenter.onDispositivoClicked(0);
        verify(view, times(1)).openDispositivoDetails(comprobar);

        dao.deleteAll();
    }

}
