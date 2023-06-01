package es.unican.hapisecurity.utilidad;

import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {

    /**
     * Metodo para comprobar en los test de interfaz si una lista tiene elementos. Para
     * utilizarlo se usa:
     * onView(withId(R.id.id_de_la_lista)).check(matches(hasElements()))
     *
     * @return Matcher<View>
     */
    public static Matcher<View> hasElements() {
        return new TypeSafeMatcher<>() {
            @Override
            public boolean matchesSafely(final View view) {
                return ((ListView) view).getCount() > 0;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("ListView should not be empty");
            }
        };
    }

    /**
     * Metodo para comprobar en los test de interfaz si una lista tiene un numero determinado
     * de elementos. Para utilizarlo se usa:
     * onView(withId(R.id.id_de_la_lista)).check(matches(sizeElements(num)))
     * @param num numero a comprobar
     * @return Matcher<View>
     */
    public static Matcher<View> sizeElements(int num) {
        return new TypeSafeMatcher<>() {
            @Override
            public boolean matchesSafely(final View view) {
                return ((ListView) view).getCount() == num;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("ListView elements doesnt match with the number");
            }
        };
    }
}
