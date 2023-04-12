package es.unican.hapisecurity.activities.menuLateral;

import android.os.Bundle;
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
        seleccionarOpcionMenu(R.id.nav_buscador);
    }

    public void seleccionarOpcionMenu(int itemId) {
        GlobalState.getInstance().setSelectedMenuIndex(itemId);
        Fragment fragment = null;
        TextView titulo = findViewById(R.id.toolbar_title);
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
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        assert fragment != null;
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
