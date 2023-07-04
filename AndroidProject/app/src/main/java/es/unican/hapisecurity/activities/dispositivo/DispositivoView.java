package es.unican.hapisecurity.activities.dispositivo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import es.unican.hapisecurity.R;
import es.unican.hapisecurity.common.Dispositivo;
import es.unican.hapisecurity.repository.db.DispositivosDB;

public class DispositivoView extends AppCompatActivity implements IDispositivoContract.View {

    public static final String DISPOSITIVO = "DISPOSITIVO";

    private IDispositivoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivo_detalle);
        Dispositivo dispositivo = (Dispositivo) getIntent().getExtras().getSerializable(DISPOSITIVO);
        DispositivosDB db = DispositivosDB.getDB(getApplicationContext());
        this.presenter = new DispositivoPresenter(this, dispositivo, db);
        this.init();
        presenter.init();
    }

    @Override
    public void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Dispositivo");
        Drawable flechaAtras = ContextCompat.getDrawable(this, R.drawable.ic_flecha_atras);
        getSupportActionBar().setHomeAsUpIndicator(flechaAtras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView imageFavoritos = findViewById(R.id.ivFavorito);
        imageFavoritos.setOnClickListener(v -> presenter.anhadeOEliminaFavoritos());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void ponerDatosDispositivo(String url, String nombre, String marca, String categoria, String precio,
                                      String seguridad, String sostenibilidad, String descripcion, String posSeg,
                                      String negSeg, String posSost, String negSost) {

        ImageView ivImagen = findViewById(R.id.ivRotulo);
        if (url != null && !url.isEmpty()) {
            Picasso.get().load(url).resize(350,350).into(ivImagen);
        }
        TextView tvNombre = findViewById(R.id.tvNombreDispositivo);
        TextView tvMarca = findViewById(R.id.tvMarcaDispositivo);
        TextView tvCategoria = findViewById(R.id.tvCategoriaDispositivo);
        TextView tvPrecio = findViewById(R.id.tvPrecioDispositivo);
        TextView tvSeguridad = findViewById(R.id.tvSeguridadDispositivo);
        TextView tvSostenibilidad = findViewById(R.id.tvSostenibilidadDispositivo);
        TextView tvDescripcion = findViewById(R.id.tvDescripcionTexto);
        TextView tvPositivoSeguridad = findViewById(R.id.tvPositivoSeguridad);
        TextView tvNegativoSeguridad = findViewById(R.id.tvNegativoSeguridad);
        TextView tvPositivoSostenibilidad = findViewById(R.id.tvPositivoSostenibilidad);
        TextView tvNegativoSostenibilidad = findViewById(R.id.tvNegativoSostenibilidad);

        tvNombre.setText(nombre);
        tvMarca.setText(marca);
        tvCategoria.setText(categoria);
        tvPrecio.setText(precio);
        tvSeguridad.setText(seguridad);
        tvSostenibilidad.setText(sostenibilidad);
        tvDescripcion.setText(descripcion);
        tvPositivoSeguridad.setText(posSeg);
        tvNegativoSeguridad.setText(negSeg);
        tvPositivoSostenibilidad.setText(posSost);
        tvNegativoSostenibilidad.setText(negSost);
    }

    @Override
    public void noEstaDB() {
        ImageView imageFavoritos = findViewById(R.id.ivFavorito);
        imageFavoritos.setImageResource(R.drawable.favorito_off);
    }

    @Override
    public void siEstaDB() {
        ImageView imageFavoritos = findViewById(R.id.ivFavorito);
        imageFavoritos.setImageResource(R.drawable.favorito_on);
    }

}
