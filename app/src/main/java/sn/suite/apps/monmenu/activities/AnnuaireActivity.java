package sn.suite.apps.monmenu.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.adapters.AnnuaireAdapter;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Resto;

public class AnnuaireActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annuaire);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialisation du nav left
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.left_nav_view);
        navigationView.getMenu().getItem(3).setChecked(true).setIcon(R.drawable.left_checked_telephone);
        navigationView.setNavigationItemSelectedListener(this);
        //END Initialisation du nav left


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.annuaire);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Resto> annuaire = DatasUtils.loadRestos();
        AnnuaireAdapter adapter = new AnnuaireAdapter(getApplicationContext(), annuaire);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_annuaire, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_annuaire) {
            Intent i = new Intent(getApplicationContext(),AnnuaireActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_lieux) {
            Intent i = new Intent(getApplicationContext(),MapsActivity.class);
            startActivity(i);
            return true;
        }
        return false;
    }

}
