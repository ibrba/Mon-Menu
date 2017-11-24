package sn.suite.apps.monmenu.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.adapters.InfoAdapter;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Resto;
import sn.suite.apps.monmenu.datas.SiteResto;

public class InfosActivity extends AppCompatActivity {

    private Integer idResto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.sitesresto);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<SiteResto> sitesList = DatasUtils.loadSites();
        InfoAdapter adapter = new InfoAdapter(getApplicationContext(), sitesList);
        recyclerView.setAdapter(adapter);

        //Recuperation des données
        Intent i = getIntent();
        idResto = i.getExtras().getInt("idResto");
        Resto restoObject = DatasUtils.getResto(idResto);
        getSupportActionBar().setTitle("Infos "+restoObject.getNom());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
