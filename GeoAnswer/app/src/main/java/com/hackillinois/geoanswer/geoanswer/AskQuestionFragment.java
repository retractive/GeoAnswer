package com.hackillinois.geoanswer.geoanswer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link DisplayQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AskQuestionFragment extends Fragment {
    private static final String ARG_LOCATION_TEXT = "locationText";

    //Widgets
    private String fillInLocation = null;
    private TextView location; //the location
    private Button askButton;
    private EditText askBox;


    /**
     *
     */
    public static AskQuestionFragment newInstance(String location) {
        AskQuestionFragment fragment = new AskQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LOCATION_TEXT, location);
        fragment.setArguments(args);
        return fragment;
    }

    public AskQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fillInLocation = getArguments().getString(ARG_LOCATION_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_ask_question, container, false);
        //Instantiante widgets
        location = (TextView) view.findViewById(R.id.locationDisplay);
        askButton = (Button) view.findViewById(R.id.askButton);
        askBox = (EditText) view.findViewById(R.id.askBox);
        location.setText(fillInLocation);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ////KAD frag logic goes here basically

        //set callback -- go back to "Location Feed" screen
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int commit = getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, LocationFeedFragment.newInstance(fillInLocation, askBox.getText().toString())) //TODO
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
