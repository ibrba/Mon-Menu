package sn.suite.apps.monmenu.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.List;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.adapters.BchaudesAdapter;
import sn.suite.apps.monmenu.adapters.DetailsPagerAdapter;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Produit;
import sn.suite.apps.monmenu.datas.Resto;
import sn.suite.apps.monmenu.fragments.BChaudesFragment;
import sn.suite.apps.monmenu.fragments.BFroidesFragment;
import sn.suite.apps.monmenu.fragments.EauxFragment;

public class DetailsRestoActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    //Fragments
    BChaudesFragment chaudesFragment;
    BFroidesFragment froidesFragment;
    EauxFragment eauxFragment;

    //Buttons
    private MaterialFavoriteButton boutonFavori;
    private ImageButton boutonAppel;
    private ImageButton boutonInfo;
    private ImageButton boutonEvent;
    private Integer idResto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_resto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar) ;
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialisation des boutons
        boutonFavori = (MaterialFavoriteButton) findViewById(R.id.favoriButton);
        boutonAppel = (ImageButton) findViewById(R.id.callButton);
        boutonInfo = (ImageButton) findViewById(R.id.infoButton);
        boutonEvent = (ImageButton) findViewById(R.id.eventButton);

        //Recuperation des données
        Intent i = getIntent();
        idResto = i.getExtras().getInt("idResto");
        Resto restoObject = DatasUtils.getResto(idResto);
        getSupportActionBar().setTitle("Détails "+restoObject.getNom());
        appBarLayout.setBackgroundDrawable(getResources().getDrawable(restoObject.getImageID()));
        boutonFavori.setFavorite(restoObject.isFavori());

        //Initialisation de viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);


        boutonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),InfosActivity.class);
                i.putExtra("idResto",idResto );
                startActivity(i);

            }
        });
        boutonEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EventActivity.class);
                i.putExtra("idResto",idResto );
                startActivity(i);
            }
        });
        boutonAppel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+221771498639" ));
                startActivity(intent);
            }
        });




        //Initialisation de tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shopping) {
            return true;
        }


        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager)
    {
        DetailsPagerAdapter adapter = new DetailsPagerAdapter(getSupportFragmentManager());
        chaudesFragment=new BChaudesFragment();
        froidesFragment=new BFroidesFragment();
        eauxFragment=new EauxFragment();
        adapter.addFragment(chaudesFragment,"BOISSONS CHAUDES");
        adapter.addFragment(froidesFragment,"BOISSONS FROIDES");
        adapter.addFragment(eauxFragment,"EAUX");
        viewPager.setAdapter(adapter);
    }

}
