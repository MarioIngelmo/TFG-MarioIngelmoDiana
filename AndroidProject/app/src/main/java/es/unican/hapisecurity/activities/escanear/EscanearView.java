package es.unican.hapisecurity.activities.escanear;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.List;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.dispositivo.DispositivoView;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.common.GlobalState;
import es.unican.hapisecurity.common.Red;
import es.unican.hapisecurity.repository.DispositivosRepository;
import es.unican.hapisecurity.repository.IDispositivosRepository;

public class EscanearView extends Fragment implements DecoratedBarcodeView.TorchListener, IEscanearContract.View {

    private IEscanearContract.Presenter presenter;

    private CompoundBarcodeView barcodeScannerView;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        this.view = inflater.inflate(R.layout.fragment_escanear, container, false);

        if (Red.isNetworkAvailable(this.requireContext())) {
            presenter = new EscanearPresenter(this, true);
        } else {
            presenter = new EscanearPresenter(this, false);
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

        // Compruebo que tenga los permisos de la cámara y sino los solicito para poder utilizarla
        if (androidx.core.content.ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED && androidx.core.content.ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permisos = {Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(requireActivity(), permisos, 0);
        }

        // Creo el Barcode Scanner y pongo un texto para guiar al usuario
        barcodeScannerView = view.findViewById(R.id.barcode_scanner);
        barcodeScannerView.setTorchListener(this);
        barcodeScannerView.setStatusText("Por favor, escanea el código de barras");


        // Aqui gestiono la lectura de un codigo de barras indicandole que una vez lee uno ya está
        barcodeScannerView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                String codigoBarras = result.getText();
                presenter.getDispositivo(codigoBarras);
                // Detiene la lectura
                onPause();
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
                // Handle possible result points
            }
        });
    }

    @Override
    public IDispositivosRepository getRepositorioDispositivos() {
        return new DispositivosRepository(this.getContext());
    }

    @Override
    public void showErrorRed() {
        onResume();
        String text = "No se ha podido cargar el dispositivo por falta de red";
        Toast.makeText(this.getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorServidor() {
        onResume();
        String text = "El dispositivo no existe o no se ha podido cargar";
        Toast.makeText(this.getContext(), text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void openDispositivo(Dispositivo dispositivoMostrar) {
        Intent intent = new Intent(this.getContext(), DispositivoView.class);
        intent.putExtra(DispositivoView.DISPOSITIVO, dispositivoMostrar);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        barcodeScannerView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeScannerView.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        barcodeScannerView.getBarcodeView().stopDecoding();
    }

    @Override
    public void onTorchOn() {
        // Handle torch on event
    }

    @Override
    public void onTorchOff() {
        // Handle torch off event
    }

}