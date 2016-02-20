package com.hackillinois.geoanswer.geoanswer;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Owner on 2/20/2016.
 */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        //always:
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // the map goes here
       SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.map);
       mapFragment.getMapAsync(this);


       // the feed goes here



    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }



}
