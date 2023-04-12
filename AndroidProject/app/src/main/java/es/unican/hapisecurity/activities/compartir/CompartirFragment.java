package es.unican.hapisecurity.activities.compartir;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.GlobalState;

public class CompartirFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_compartir, container, false);

        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        // Doy funcionalidad al boton de compartir
        Button compartirBtn = view.findViewById(R.id.btnCompartir);
        compartirBtn.setOnClickListener(v -> compartirApp());

        return view;
    }

    /**
     * Creo un intent en el que comparto un texto plano con el mensaje que quiero que se envíe
     * al compartir y después hago que se abra el selector para compartir y el usuario seleccione
     * cuál de todos quiere.
     */
    private void compartirApp() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareBody = "Unete a mi y descarga HapiSecurity";
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Descarga HapiSecurity");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent, "Compartir vía"));
    }

}
