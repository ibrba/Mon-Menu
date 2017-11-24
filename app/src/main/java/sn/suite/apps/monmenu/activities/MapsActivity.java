package sn.suite.apps.monmenu.activities;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Lieu;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Lieu [] lieux = DatasUtils.lieux;
        for(int i = 0 ; i < lieux.length ; i++ ) {
            placerLieu(lieux[i].getLat(), lieux[i].getLng(),"Resto");
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lieux[0].getLat(), lieux[0].getLng())));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(11));
    }

    protected Marker placerLieu(double latitude, double longitude,String title) {
        LatLng lieu = new LatLng(latitude, longitude);
        return mMap.addMarker(new MarkerOptions().position(lieu).title(title).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
    }
}
