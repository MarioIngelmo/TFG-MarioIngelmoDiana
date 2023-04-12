package es.unican.hapisecurity.activities.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.GlobalState;

public class FavoritosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        return view;
    }

}
