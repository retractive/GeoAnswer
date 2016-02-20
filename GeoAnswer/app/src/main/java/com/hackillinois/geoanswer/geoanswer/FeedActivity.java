package com.hackillinois.geoanswer.geoanswer;

import android.app.ListActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by willa on 2/20/16.
 */
public class FeedActivity extends ListActivity {

    private ArrayList<Question> qFeed;
    private Question temp;


    protected void onCreate(Bundle savedInstanceState) {
        //always:
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
