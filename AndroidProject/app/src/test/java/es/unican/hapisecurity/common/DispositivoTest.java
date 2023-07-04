package es.unican.hapisecurity.common;

import static org.junit.Assert.assertEquals;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class DispositivoTest {

    private static final String ID = "3534265265";
    private static final String URL = "https://www.bombillaTest.es";
    private static final String NOMBRE = "Bombilla Test";
    private static final String MARCA = "Test";
    private static final String DESCRIPCION = "Bombilla para el test del dispositivo";
    private static final Categoria CATEGORIA = Categoria.Iluminacion;
    private static final String PRECIO = "135";
    private static final int SEGURIDAD = 95;
    private static final String SOSTENIBILIDAD = "A";

    /**
     * Test para comprobar que el dispositivo se crea correctamente y los setters y getters funcionan
     */
    @Test
    public void inicializaDispositivoTest() {
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

        assertEquals(ID, d.getDispositivoId());
        assertEquals(URL, d.getUrlImagen());
        assertEquals(NOMBRE, d.getNombre());
        assertEquals(MARCA, d.getMarca());
        assertEquals(DESCRIPCION, d.getDescripcion());
        assertEquals(CATEGORIA, d.getCategoria());
        assertEquals(PRECIO, d.getPrecio());
        assertEquals(SEGURIDAD, d.getSeguridad());
        assertEquals(SOSTENIBILIDAD, d.getSostenibilidad());
    }

}
