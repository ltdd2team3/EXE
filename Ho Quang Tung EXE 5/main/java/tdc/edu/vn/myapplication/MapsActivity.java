package tdc.edu.vn.myapplication;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RadioButton normal, layers, hybrid, terrain;

    public static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setControl();


    }

    private void setControl() {
        normal = (RadioButton) findViewById(R.id.normal);
        hybrid = (RadioButton) findViewById(R.id.hybrid);
        layers = (RadioButton) findViewById(R.id.layers);
        terrain = (RadioButton) findViewById(R.id.terrain);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        setEvent();


        LatLng hcm = new LatLng(10.852197, 106.758381);

        mMap.addMarker(new MarkerOptions().position(hcm).title("Marker in HCM City"));
        CameraPosition cp = new CameraPosition.Builder().target(hcm).zoom(13).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    private void setEvent() {
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        layers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        UiSettings mapUiSettings = mMap.getUiSettings();
        mapUiSettings.setZoomControlsEnabled(true);
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

    private void createMap() {
        SupportMapFragment smf = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        smf.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createMap();
    }


}
