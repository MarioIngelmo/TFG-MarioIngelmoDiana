package es.unican.hapisecurity.activities.buscador;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static es.unican.hapisecurity.utilidad.Matchers.hasElements;

import static org.hamcrest.Matchers.*;

import android.view.KeyEvent;
import android.widget.SearchView;

import androidx.test.espresso.DataInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.menu_lateral.MenuInicialActivity;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

public class BuscadorUITest {

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
     * Test para probar el buscador
     */
    @Test
    public void pruebaBuscadorTest() {
        // Compruebo que se ha abierto el fragment buscador y que la lista tiene los dispositivos
        onView(withId(R.id.lvDispositivos)).check(matches(hasElements()));
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos))
                .atPosition(0).onChildView(withId(R.id.tvName))
                .check(matches(withText("Amazon Echo")));
        // Escribo apple en el buscador y compruebo que los dispositivos que quedan son los que deberían
        onView(allOf(instanceOf(SearchView.class), withId(R.id.svBuscador)))
                .perform(typeText("Apple")).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        // Compruebo que la lista tiene los 2 dispositivos de apple
        onView(withId(R.id.lvDispositivos)).check(matches(hasElements()));
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos))
                .atPosition(0).onChildView(withId(R.id.tvName))
                .check(matches(withText("Apple HomePod")));
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos))
                .atPosition(1).onChildView(withId(R.id.tvName))
                .check(matches(withText("Apple HomePod Mini")));
        // Borro el buscador y compruebo que los elementos se resetean a todos
        onView(allOf(instanceOf(SearchView.class), withId(R.id.svBuscador)))
                .perform(pressKey(KeyEvent.KEYCODE_DEL)).perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL)).perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL)).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        // Compruebo que la lista tiene los dispositivos y el primero coincide otra vez
        onView(withId(R.id.lvDispositivos)).check(matches(hasElements()));
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos))
                .atPosition(0).onChildView(withId(R.id.tvName))
                .check(matches(withText("Amazon Echo")));
    }


    /**
     * Test para probar que los datos de la lista se ponen correctamente
     */
    @Test
    public void pruebaDispositivoResumenTest() {
        // Compruebo que los datos del primer dispositivo son correctos
        onView(withId(R.id.lvDispositivos)).check(matches(hasElements()));
        DataInteraction d = onData(anything()).inAdapterView(withId(R.id.lvDispositivos))
                .atPosition(0);
        d.onChildView(withId(R.id.tvName)).check(matches(withText("Amazon Echo")));
        d.onChildView(withId(R.id.tvMarca)).check(matches(withText("Amazon")));
        d.onChildView(withId(R.id.tvSeg)).check(matches(withText("70")));
        d.onChildView(withId(R.id.tvSost)).check(matches(withText("B")));
    }

}
