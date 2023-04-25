package es.unican.hapisecurity.activities.buscador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.GlobalState;

public class BuscadorFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_buscador, container, false);

        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        SearchView searchView = view.findViewById(R.id.svBuscador);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Realizar la búsqueda aquí
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

        });

        return view;
    }

}
