package com.hackillinois.geoanswer.geoanswer;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Owner on 2/20/2016.
 */
public class MainActivity extends FragmentActivity implements OnMapReadyCallback
        {

   private GoogleMap    mMap;
            private Marker marker;
            ViewGroup view;
            @Override
    protected void onCreate(Bundle savedInstanceState) {
       //always:

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.mapview);

                mapFragment.getMapAsync(this);*/
      getFragmentManager()
               .beginTransaction()
               .replace(R.id.top_fragment_container, MapsActivity.newInstance())
               .addToBackStack(null)
               .commit();

       getFragmentManager()
               .beginTransaction()
               .replace(R.id.bottom_fragment_container, AskQuestionFragment.newInstance("Ask a question"))
               .addToBackStack(null)
               .commit();

       // the map goes here
//       SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//               .findFragmentById(R.id.map);
//       mapFragment.getMapAsync(this);
//
//    }

   }

            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // Add a marker in Sydney and move the camera
                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
//
//    @Override
//    public void onMapReady(GoogleMap map) {
//        map.addMarker(new MarkerOptions()
//                .position(new LatLng(0, 0))
//                .title("Marker"));
//    }



}
