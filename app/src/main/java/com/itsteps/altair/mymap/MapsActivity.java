package com.itsteps.altair.mymap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;

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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        DecimalFormat df = new DecimalFormat("#.####");

        mMap.setOnMapClickListener(map -> {
            LatLng position = new LatLng(map.latitude, map.longitude);
            String lat = "lat: "+ String.valueOf(df.format(position.latitude));
            String lng = "lng: "+ String.valueOf(df.format(position.longitude));
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(position)
                    .title(lat)
                    .snippet(lng));
            marker.showInfoWindow();

            mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
        });


    }
}
