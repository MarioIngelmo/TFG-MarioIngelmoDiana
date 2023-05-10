package es.unican.hapisecurity.activities.buscador;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.GlobalState;

public class BuscadorView extends Fragment implements IBuscadorContract.View {

    private IBuscadorContract.Presenter presenter;
    private View view;
    private String categoriaSeleccionada = "Todas";
    private String categoriaTemporal = "Todas";
    private int valorSeguridad = 0;
    private int valorSeguridadTemporal = 0;
    private String valorSostenibilidad = "G";
    private String valorSostenibilidadTemporal = "G";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_buscador, container, false);
        this.view = view;

        presenter = new BuscadorPresenter(this);

        this.init();
        return view;
    }

    public void init() {
        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();

        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        // Manejar botón de filtros
        Button btnFilters = view.findViewById(R.id.btn_filters);
        btnFilters.setOnClickListener(v -> showFilterDialog());

        SearchView searchView = view.findViewById(R.id.svBuscador);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Filtros");

        // Inflar el layout personalizado del diálogo
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_filtros, null);

        // Obtener referencias de los elementos del diálogo
        Spinner spinnerCategory = dialogView.findViewById(R.id.spinner_categoria);
        SeekBar seekBarSecurity = dialogView.findViewById(R.id.seekbar_seguridad);
        SeekBar seekBarSustainability = dialogView.findViewById(R.id.seekbar_sostenibilidad);

        // Configurar el spinner de categorías
        ArrayAdapter<CharSequence> adapterCategory = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.categorias_array,
                android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);
        spinnerCategory.setSelection(adapterCategory.getPosition(categoriaSeleccionada));
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoriaTemporal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                categoriaTemporal = "Todas";
            }
        });

        // Configurar la seekbar de seguridad
        seekBarSecurity.setMax(100);
        seekBarSustainability.setKeyProgressIncrement(1);
        seekBarSecurity.setProgress(valorSeguridad);
        TextView textViewSeguridad = dialogView.findViewById(R.id.seguridad_nivel);
        textViewSeguridad.setText(String.valueOf(valorSeguridad));
        seekBarSecurity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
        seekBarSustainability.setMax(6);
        seekBarSustainability.setKeyProgressIncrement(1);
        seekBarSustainability.setProgress(Arrays.asList(sostenibilidadArray).indexOf(valorSostenibilidad));
        TextView textViewSostenibilidad = dialogView.findViewById(R.id.sostenibilidad_nivel);
        textViewSostenibilidad.setText(valorSostenibilidad);
        seekBarSustainability.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        Button botonCancelar = dialogView.findViewById(R.id.boton_cancelar);
        Button botonAplicar = dialogView.findViewById(R.id.boton_aplicar);
        botonCancelar.setOnClickListener(v -> presenter.cancelarFiltros(dialog));
        botonAplicar.setOnClickListener(v -> presenter.aplicarFiltros(dialog, categoriaTemporal, valorSeguridadTemporal, valorSostenibilidadTemporal));

        dialog.show();
    }

    @Override
    public void cierraDialogo(AlertDialog dialog) {
        dialog.dismiss();
    }

    @Override
    public void guardaValorFiltros(String categoriaTemporal, int valorSeguridadTemporal, String valorSostenibilidadTemporal) {
        categoriaSeleccionada = categoriaTemporal;
        valorSeguridad = valorSeguridadTemporal;
        valorSostenibilidad = valorSostenibilidadTemporal;
    }

}
