package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.dispositivo.DispositivoView;
import es.unican.hapisecurity.common.GlobalState;
import es.unican.hapisecurity.common.Red;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.DispositivosRepository;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public class BuscadorView extends Fragment implements IBuscadorContract.View {

    private IBuscadorContract.Presenter presenter;
    private View view;
    private static final String TODAS = "Todas";
    private static final String ALFABETICO = "Alfabetico";
    private String categoriaSeleccionada = TODAS;
    private String categoriaTemporal = TODAS;
    private int valorSeguridad = 0;
    private int valorSeguridadTemporal = 0;
    private String valorSostenibilidad = "G";
    private String valorSostenibilidadTemporal = "G";
    private String ordenarSeleccionado = ALFABETICO;
    private String ordenarTemporal = ALFABETICO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        this.view = inflater.inflate(R.layout.fragment_buscador, container, false);

        if (Red.isNetworkAvailable(this.requireContext())) {
            presenter = new BuscadorPresenter(this, categoriaSeleccionada, String.valueOf(valorSeguridad), valorSostenibilidad, ordenarSeleccionado, true);
        } else {
            presenter = new BuscadorPresenter(this, categoriaSeleccionada, String.valueOf(valorSeguridad), valorSostenibilidad, ordenarSeleccionado, false);
        }

        this.init();
        return view;
    }

    @Override
    public void init() {
        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();

        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = requireActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        // Manejar botón de filtros
        Button btnFilters = view.findViewById(R.id.btn_filters);
        btnFilters.setOnClickListener(v -> showFilterDialog());

        SearchView searchView = view.findViewById(R.id.svBuscador);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.filtraTexto(newText);
                return false;
            }
        });

        // Manejar cada vez que se pinche en un dispositivo
        ListView lvDispositivos = view.findViewById(R.id.lvDispositivos);
        lvDispositivos.setOnItemClickListener((parent, view, position, id) ->
                presenter.onDispositivoClicked(position)
        );
    }

    @Override
    public IDispositivosRepository getRepositorioDispositivos() {
        return new DispositivosRepository(this.getContext());
    }

    @Override
    public void cierraDialogo(AlertDialog dialog) {
        dialog.dismiss();
    }

    @Override
    public void guardaValorFiltros(String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal, String ordenarTemporal) {
        categoriaSeleccionada = categoriaTemporal;
        valorSeguridad = valorSeguridadTemporal;
        valorSostenibilidad = valorSostenibilidadTemporal;
        ordenarSeleccionado = ordenarTemporal;
    }

    @Override
    public void showDispositivos(List<Dispositivo> dispositivos) {
        TextView textErrorDispositivos = view.findViewById(R.id.tvErrorDispositivos);
        if (dispositivos.isEmpty()) {
            String text = "No hay dispositivos con estas características";
            textErrorDispositivos.setText(text);
        } else {
            textErrorDispositivos.setText("");
        }
        DispositivosArrayAdapter adapter = new DispositivosArrayAdapter(this.requireContext(), dispositivos);
        ListView listMostrarDispositivos = view.findViewById(R.id.lvDispositivos);
        listMostrarDispositivos.setAdapter(adapter);
    }

    @Override
    public void showErrorRed() {
        String text = "No se han podido cargar los dispositivos por falta de red";
        Toast.makeText(this.getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorServidor() {
        String text = "No se han podido cargar dispositivos";
        Toast.makeText(this.getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openDispositivoDetails(Dispositivo dispositivo) {
        Intent intent = new Intent(this.getContext(), DispositivoView.class);
        intent.putExtra(DispositivoView.DISPOSITIVO, dispositivo);
        startActivity(intent);
    }

    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Filtros");

        // Inflar el layout personalizado del diálogo
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_filtros, null);

        // Obtener referencias de los elementos del diálogo
        Spinner spinnerCategoria = dialogView.findViewById(R.id.spinner_categoria);
        SeekBar seekBarSeguridad = dialogView.findViewById(R.id.seekbar_seguridad);
        SeekBar seekBarSostenibilidad = dialogView.findViewById(R.id.seekbar_sostenibilidad);
        Spinner spinnerOrdenar = dialogView.findViewById(R.id.spinner_ordenar);

        // Configurar el spinner de categorías
        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.categorias_array,
                android.R.layout.simple_spinner_item);
        adapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapterCategoria);
        spinnerCategoria.setSelection(adapterCategoria.getPosition(categoriaSeleccionada));
        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoriaTemporal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                categoriaTemporal = TODAS;
            }
        });

        // Configurar la seekbar de seguridad
        seekBarSeguridad.setMax(100);
        seekBarSeguridad.setKeyProgressIncrement(5);
        seekBarSeguridad.setProgress(valorSeguridad);
        TextView textViewSeguridad = dialogView.findViewById(R.id.seguridad_nivel);
        textViewSeguridad.setText(String.valueOf(valorSeguridad));
        seekBarSeguridad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeguridad.setText(String.valueOf(progress));
                valorSeguridadTemporal = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No hace nada
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No hace nada
            }
        });

        // Configurar la seekbar de sostenibilidad
        final String[] sostenibilidadArray = {"A", "B", "C", "D", "E", "F", "G"};
        seekBarSostenibilidad.setMax(6);
        seekBarSostenibilidad.setKeyProgressIncrement(1);
        seekBarSostenibilidad.setProgress(Arrays.asList(sostenibilidadArray).indexOf(valorSostenibilidad));
        TextView textViewSostenibilidad = dialogView.findViewById(R.id.sostenibilidad_nivel);
        textViewSostenibilidad.setText(valorSostenibilidad);
        seekBarSostenibilidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorSostenibilidadTemporal = sostenibilidadArray[progress];
                textViewSostenibilidad.setText(valorSostenibilidadTemporal);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No hace nada
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No hace nada
            }
        });

        // Configurar el spinner de ordenar
        ArrayAdapter<CharSequence> adapterOrdenar = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.ordenar_array,
                android.R.layout.simple_spinner_item);
        adapterOrdenar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrdenar.setAdapter(adapterOrdenar);
        spinnerOrdenar.setSelection(adapterOrdenar.getPosition(ordenarSeleccionado));
        spinnerOrdenar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ordenarTemporal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ordenarTemporal = ALFABETICO;
            }
        });

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        Button botonCancelar = dialogView.findViewById(R.id.boton_cancelar);
        Button botonAplicar = dialogView.findViewById(R.id.boton_aplicar);
        botonCancelar.setOnClickListener(v -> presenter.cancelarFiltros(dialog));
        botonAplicar.setOnClickListener(v -> presenter.aplicarFiltros(dialog, categoriaTemporal, valorSeguridadTemporal, valorSostenibilidadTemporal, ordenarTemporal));

        dialog.show();
    }

}
