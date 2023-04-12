package es.unican.hapisecurity.activities.menu_lateral;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import es.unican.hapisecurity.R;
import es.unican.hapisecurity.activities.buscador.BuscadorFragment;
import es.unican.hapisecurity.activities.compartir.CompartirFragment;
import es.unican.hapisecurity.activities.escanear.EscanearFragment;
import es.unican.hapisecurity.activities.favoritos.FavoritosFragment;
import es.unican.hapisecurity.common.GlobalState;


public class MenuInicialActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Configuración del menú lateral
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    seleccionarOpcionMenu(menuItem.getItemId());
                    return true;
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        // Agregar el botón de hamburguesa para abrir el menú lateral
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle); // Agregar listener antes de sincronizar
        actionBarDrawerToggle.syncState(); // Sincronizar después de agregar listener
        // Hago que por defecto se abra el buscador
        seleccionarOpcionMenu(R.id.nav_buscador);
    }

    /**
     * Método que sirve para cambiar entre los diferentes fragmentos del menú lateral
     * @param itemId entero que contiene el id del fragmento a cambiar
     */
    public void seleccionarOpcionMenu(int itemId) {
        Fragment fragment = null;
        TextView titulo = findViewById(R.id.toolbar_title);
        // Selecciono con el id el fragment correspondiente y lo creo
        switch (itemId) {
            case R.id.nav_buscador:
                fragment = new BuscadorFragment();
                titulo.setText(R.string.menu_buscador);
                break;
            case R.id.nav_escanear:
                fragment = new EscanearFragment();
                titulo.setText(R.string.menu_escanear);
                break;
            case R.id.nav_favoritos:
                fragment = new FavoritosFragment();
                titulo.setText(R.string.menu_favoritos);
                break;
            case R.id.nav_compartir:
                fragment = new CompartirFragment();
                titulo.setText(R.string.menu_compartir);
                break;
            default:
                finish();
        }
        // Actualizo el indice global para tener el cambio
        GlobalState.getInstance().setSelectedMenuIndex(itemId);
        // Abro el fragment correspondiente cambiándolo por el anterior
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        assert fragment != null;
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Compruebo si el menú lateral está abierto o no para poder cerrarlo sin cerrar la aplicación entera
        if (keyCode == KeyEvent.KEYCODE_BACK && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
