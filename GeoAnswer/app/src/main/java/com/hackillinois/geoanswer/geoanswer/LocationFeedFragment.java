package com.hackillinois.geoanswer.geoanswer;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
public class LocationFeedFragment extends Fragment {
    private String locationName;

    private static final String ARG_LOCATION_TEXT = "locationText";
    private static final String ARG_QUESTION_TEXT = "newQuestion";

    private String exampleUser = "John Smith";
    private String defaultQuestion = "Got a question? Submit your own...";

    //Widgets
    private ListView questionList; //the questions at this location
    private TextView location; //the location
    private ArrayList<String> questions;
    private ArrayAdapter<String> adapter;
    private Button askQuestionButton;
    private String newQuestion = null;


    interface Listener {
        public void passInfo(ArrayList<String> Qs);
    }

    private Listener myListener;

    public void setMyListener(Listener li) {
        myListener = li;
    }


    public static LocationFeedFragment newInstance(String location, String question) {
        LocationFeedFragment fragment = new LocationFeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LOCATION_TEXT, location);
        args.putString(ARG_QUESTION_TEXT, question);
        fragment.setArguments(args);
        return fragment;
    }

    public LocationFeedFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            locationName = getArguments().getString(ARG_LOCATION_TEXT);
            newQuestion = getArguments().getString(ARG_QUESTION_TEXT);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_location_feed, container, false);
        //Instantiante widgets
        questionList = (ListView) view.findViewById(R.id.questionList);
        location = (TextView) view.findViewById(R.id.locationDisplay);
        location.setText(locationName);

        // get QuestionList from main QVActivity
        QuestionViewActivity test = (QuestionViewActivity) getActivity();
        //Question feed
        questions = test.getQuestionList();



        String exQuestionSubmission;

        if (newQuestion != null) {
            questions.add(newQuestion);
        }


        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, questions);
        questionList.setAdapter(adapter);

        //KAD new

        questionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String questionClicked = parent.getItemAtPosition(position).toString();

                //go to QuestionViewFragment->"Display Question" screen
                int commit = getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, DisplayQuestionFragment.newInstance(null, questionClicked))
                        .addToBackStack(null)
                        .commit();
            }
        });


        askQuestionButton = (Button) view.findViewById(R.id.askQuestionButton);

        askQuestionButton.setOnClickListener(new View.OnClickListener() {

            // String q = question.getText().toString();
            @Override
            public void onClick(View v) {

                //go to QuestionViewFragment->"Ask Question" screen
                int commit = getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, AskQuestionFragment.newInstance(locationName))
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;

    }
}