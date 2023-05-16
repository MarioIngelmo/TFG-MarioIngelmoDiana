package es.unican.hapisecurity.activities.buscador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.Dispositivo;

public class DispositivosArrayAdapter extends ArrayAdapter<Dispositivo> {

    public DispositivosArrayAdapter(@NonNull Context context, @NonNull List<Dispositivo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Dispositivo dispositivo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.activity_dispositivo_resumen, parent, false);
        }

        // imagen
        setImagen(dispositivo, convertView);
        // nombre
        setNombre(dispositivo, convertView);
        // marca
        setMarca(dispositivo, convertView);
        // seguridad
        setSeguridad(dispositivo, convertView);
        // nobre
        setSostenibilidad(dispositivo, convertView);

        return convertView;
    }

    private void setImagen(Dispositivo dispositivo, View convertView) {
        ImageView ivImagen = convertView.findViewById(R.id.ivFotoDisp);
        String direccionImagen = dispositivo.getUrlImagen();
        if (direccionImagen != null && !direccionImagen.isEmpty()) {
            Picasso.get().load(direccionImagen).into(ivImagen);
        }
    }

    private void setNombre(Dispositivo dispositivo, View convertView) {
        TextView tvNombre = convertView.findViewById(R.id.tvName);
        tvNombre.setText(dispositivo.getNombre());
    }

    private void setMarca(Dispositivo dispositivo, View convertView) {
        TextView tvMarca = convertView.findViewById(R.id.tvMarca);
        tvMarca.setText(dispositivo.getMarca());
    }

    private void setSeguridad(Dispositivo dispositivo, View convertView) {
        TextView tvSeguridad = convertView.findViewById(R.id.tvSeg);
        tvSeguridad.setText(String.valueOf(dispositivo.getSeguridad()));
    }

    private void setSostenibilidad(Dispositivo dispositivo, View convertView) {
        TextView tvSostenibilidad = convertView.findViewById(R.id.tvSost);
        tvSostenibilidad.setText(dispositivo.getSostenibilidad());
    }

}
