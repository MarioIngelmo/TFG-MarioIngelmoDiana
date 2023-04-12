package es.unican.hapisecurity.activities.escanear;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import es.unican.hapisecurity.common.GlobalState;

public class EscanearFragment extends Fragment implements DecoratedBarcodeView.TorchListener {

    private CompoundBarcodeView barcodeScannerView;
    private String codigoBarras = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creo la view para la actividad principal con el xml correspondiente
        View view = inflater.inflate(R.layout.fragment_escanear, container, false);

        // Selecciono el indice para remarcar en el menú lateral
        int selectedMenuIndex = GlobalState.getInstance().getSelectedMenuIndex();
        // Resaltar el ítem correspondiente en el menú lateral
        NavigationView navigationView = getActivity().findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(selectedMenuIndex);

        // Compruebo que tenga los permisos de la cámara y sino los solicito para poder utilizarla
        if (androidx.core.content.ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED && androidx.core.content.ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permisos = {Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(getActivity(), permisos, 0);
        }

        // Creo el Barcode Scanner y pongo un texto para guiar al usuario
        barcodeScannerView = view.findViewById(R.id.barcode_scanner);
        barcodeScannerView.setTorchListener(this);
        barcodeScannerView.setStatusText("Por favor, escanea el código de barras");

        // Esto es temporal para comprobar que el lector funciona
        TextView toolTitle = getActivity().findViewById(R.id.toolbar_title);

        // Aqui gestiono la lectura de un codigo de barras indicandole que una vez lee uno ya está
        barcodeScannerView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                codigoBarras = result.getText();
                // Esto tambien es temporal
                toolTitle.setText(codigoBarras);
                // Detiene la lectura
                onDestroy();
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
                // Handle possible result points
            }
        });

        return view;
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