package es.unican.hapisecurity.activities.menu_lateral;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.google.android.material.navigation.NavigationView;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.repository.rest.DispositivosServiceConstants;

public class NavegacionMenuUITest {

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

    @Test
    public void pruebaNavegacionTest() {
        onView(withId(R.id.drawer_layout)).perform(click());
        onView(withId(R.id.navigation_view)).perform(click());
        onView(withId(R.id.nav_compartir)).perform(click());
    }

}
