package es.unican.hapisecurity.activities.menu_lateral;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static es.unican.hapisecurity.utilidad.Matchers.hasElements;

import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.escanear.EscanearView;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

public class NavegacionMenuUITest {

    @BeforeClass
    public static void setUp() {
        DispositivosServiceConstants.setPruebasUrl();
        EscanearView.setPruebas(true);
    }

    @AfterClass
    public static void clean() {
        DispositivosServiceConstants.setApiUrl();
        EscanearView.setPruebas(false);
    }

    @Rule
    public ActivityScenarioRule<MenuInicialActivity> activityRule =
            new ActivityScenarioRule(MenuInicialActivity.class);

    /**
     * Test donde se comprueba que la navegacion funciona correctamente
     */
    @Test
    public void pruebaNavegacionTest() {
        // Compruebo que el menú al principio esta cerrado
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
        // Abro el menu
        onView(withId(R.id.drawer_layout)).perform(open());
        // Abro el fragment de compartir
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.nav_compartir));
        // Compruebo que se ha abierto el fragment
        onView(withId(R.id.tvAgradecimiento)).check(matches(isDisplayed()));

        // Abro el menu
        onView(withId(R.id.drawer_layout)).perform(open());
        // Abro el fragment de escanear
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.nav_escanear));
        // Compruebo que se ha abierto el fragment
        onView(withId(R.id.barcode_scanner)).check(matches(isDisplayed()));

        // Abro el menu
        onView(withId(R.id.drawer_layout)).perform(open());
        // Abro el fragment de favoritos
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.nav_favoritos));
        // Compruebo que se ha abierto el fragment
        onView(withId(R.id.tvErrorFavoritos)).check(matches(isDisplayed()));

        // Abro el menu
        onView(withId(R.id.drawer_layout)).perform(open());
        // Abro el fragment de buscador
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.nav_buscador));
        // Compruebo que se ha abierto el fragment
        onView(withId(R.id.lvDispositivos)).check(matches(hasElements()));
    }

}