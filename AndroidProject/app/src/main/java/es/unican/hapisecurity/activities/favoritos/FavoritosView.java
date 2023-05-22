package es.unican.hapisecurity.activities.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.GlobalState;

public class FavoritosView extends Fragment implements IFavoritosContract.View {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = requireActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        TextView textFavoritos = view.findViewById(R.id.tvErrorFavoritos);
        String textoSinFavoritos = "Todavia no hay dispositivos favoritos agregados";
        textFavoritos.setText(textoSinFavoritos);

        return view;
    }

}
