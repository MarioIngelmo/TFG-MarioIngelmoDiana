package es.unican.hapisecurity.activities.dispositivo;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.notNullValue;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.menu_lateral.MenuInicialActivity;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

public class DispositivoUITest {

    @BeforeClass
    public static void setUp() {
        DispositivosServiceConstants.setPruebasUrl();
    }

    @AfterClass
    public static void clean() {
        DispositivosServiceConstants.setApiUrl();
    }

    @Rule
    public ActivityScenarioRule<MenuInicialActivity> activityRule =
            new ActivityScenarioRule(MenuInicialActivity.class);

    /**
     * Test donde se prueba que los datos del dispositivo son correctos al abrirlo
     */
    @Test
    public void pruebaDetallesDispositivoTest() {
        // Selecciono el primer dispositivo de la lista para probar
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos)).atPosition(0).perform(click());
        // Compruebo que la imagen se despliega
        onView(withId(R.id.ivRotulo)).check(matches(isDisplayed()));
        // Compruebo que el nombre es correcto
        onView(withId(R.id.tvNombreDispositivo)).check(matches(withText("Amazon Echo")));
        // Compruebo que la marca es correcta
        onView(withId(R.id.tvMarcaDispositivo)).check(matches(withText("Amazon")));
        // Compruebo que la categoria es correcta
        onView(withId(R.id.tvCategoriaDispositivo)).check(matches(withText("Asistente Virtual")));
        // Compruebo que el precio es correcto
        onView(withId(R.id.tvPrecioDispositivo)).check(matches(withText("30 €")));
        // Compruebo que la seguridad es correcta
        onView(withId(R.id.tvSeguridadDispositivo)).check(matches(withText("70 / 100")));
        // Compruebo que la sostenibilidad es correcta
        onView(withId(R.id.tvSostenibilidadDispositivo)).check(matches(withText("B")));
        // Compruebo que la descripcion no esta vacia
        onView(withId(R.id.tvDescripcionTexto)).check(matches(notNullValue()));
        // Compruebo que la lista de caracteristicas de seguridad positivas no esta vacia
        onView(withId(R.id.tvPositivoSeguridad)).perform(scrollTo()).check(matches(notNullValue()));
        // Compruebo que la lista de caracteristicas de seguridad negativas no esta vacia
        onView(withId(R.id.tvNegativoSeguridad)).perform(scrollTo()).check(matches(notNullValue()));
        // Compruebo que la lista de caracteristicas de sostenibilidad positivas no esta vacia
        onView(withId(R.id.tvPositivoSostenibilidad)).perform(scrollTo()).check(matches(notNullValue()));
        // Compruebo que la lista de caracteristicas de sostenibilidad negativas no esta vacia
        onView(withId(R.id.tvNegativoSostenibilidad)).perform(scrollTo()).check(matches(notNullValue()));
    }

}
