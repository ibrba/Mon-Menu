package sn.suite.apps.monmenu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.adapters.EventsAdapter;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Evenement;
import sn.suite.apps.monmenu.datas.Resto;

public class EventActivity extends AppCompatActivity {

    private Integer idResto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.eventsgallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Evenement> eventsList = DatasUtils.loadEvents();
        EventsAdapter adapter = new EventsAdapter(getApplicationContext(), eventsList);
        recyclerView.setAdapter(adapter);

        //Recuperation des données
        Intent i = getIntent();
        idResto = i.getExtras().getInt("idResto");
        Resto restoObject = DatasUtils.getResto(idResto);
        getSupportActionBar().setTitle("Evenements "+restoObject.getNom());

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
