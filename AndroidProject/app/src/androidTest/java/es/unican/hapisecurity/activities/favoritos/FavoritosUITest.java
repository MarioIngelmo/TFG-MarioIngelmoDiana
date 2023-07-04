package es.unican.hapisecurity.activities.favoritos;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.menu_inicial.MenuInicialActivity;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

public class FavoritosUITest {

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
     * Test donde se prueba que se añada y elimine correctamente de favoritos
     */
    @Test
    public void pruebaFavoritosTest() {
        // Selecciono el primer dispositivo de la lista para añadir a favoritos
        onData(anything()).inAdapterView(withId(R.id.lvDispositivos)).atPosition(0).perform(click());
        // Pulso en el botón de favoritos
        onView(withId(R.id.ivFavorito)).perform(click());
        // Salgo de la vista detallada
        pressBack();
        // Voy a favoritos
        onView(withId(R.id.drawer_layout)).perform(open());
        // Abro el fragment de favoritos
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.nav_favoritos));
        // Compruebo que en la lista aparece el dispositivo añadido y sus datos son correctos
        DataInteraction d = onData(anything()).inAdapterView(withId(R.id.lvFavoritos))
                .atPosition(0);
        d.onChildView(withId(R.id.tvName)).check(matches(withText("Amazon Echo")));
        d.onChildView(withId(R.id.tvMarca)).check(matches(withText("Amazon")));
        d.onChildView(withId(R.id.tvSeg)).check(matches(withText("70")));
        d.onChildView(withId(R.id.tvSost)).check(matches(withText("B")));
        // Compruebo que la vista detallada se abre correctamente
        onData(anything()).inAdapterView(withId(R.id.lvFavoritos)).atPosition(0).perform(click());
        // Compruebo que el nombre es correcto al abrir
        onView(withId(R.id.tvNombreDispositivo)).check(matches(withText("Amazon Echo")));
        // Pulso en el botón de favoritos para eliminar
        onView(withId(R.id.ivFavorito)).perform(click());
    }

}
