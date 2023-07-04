package es.unican.hapisecurity.activities.favoritos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.buscador.DispositivosArrayAdapter;
import es.unican.hapisecurity.activities.dispositivo.DispositivoView;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.common.GlobalState;
import es.unican.hapisecurity.common.Red;
import es.unican.hapisecurity.repository.DispositivosRepository;
import es.unican.hapisecurity.repository.IDispositivosRepository;
import es.unican.hapisecurity.repository.db.DispositivosDB;

public class FavoritosView extends Fragment implements IFavoritosContract.View {

    private IFavoritosContract.Presenter presenter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        this.view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        DispositivosDB db = DispositivosDB.getDB(this.requireContext());

        if (Red.isNetworkAvailable(this.requireContext())) {
            presenter = new FavoritosPresenter(this, db, true);
        } else {
            presenter = new FavoritosPresenter(this, db, false);
        }

        this.init();
        presenter.init();
        return view;
    }

    @Override
    public void init() {
        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = requireActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        // Manejar cada vez que se pinche en un dispositivo
        ListView lvDispositivos = view.findViewById(R.id.lvFavoritos);
        lvDispositivos.setOnItemClickListener((parent, view, position, id) ->
                presenter.onDispositivoClicked(position)
        );
    }

    @Override
    public IDispositivosRepository getRepositorioDispositivos() {
        return new DispositivosRepository(this.getContext());
    }

    @Override
    public void showDispositivos(List<Dispositivo> dispositivos) {
        TextView textErrorDispositivos = view.findViewById(R.id.tvErrorFavoritos);
        if (dispositivos.isEmpty()) {
            String text = "Todavía no hay dispositivos favoritos agregados";
            textErrorDispositivos.setText(text);
        } else {
            textErrorDispositivos.setText("");
        }
        DispositivosArrayAdapter adapter = new DispositivosArrayAdapter(this.requireContext(), dispositivos);
        ListView listMostrarDispositivos = view.findViewById(R.id.lvFavoritos);
        listMostrarDispositivos.setAdapter(adapter);
    }

    @Override
    public void openDispositivoDetails(Dispositivo dispositivo) {
        Intent intent = new Intent(this.getContext(), DispositivoView.class);
        intent.putExtra(DispositivoView.DISPOSITIVO, dispositivo);
        startActivity(intent);
    }

}
