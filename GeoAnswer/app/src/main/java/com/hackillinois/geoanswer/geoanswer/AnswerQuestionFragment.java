package com.hackillinois.geoanswer.geoanswer;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link DisplayQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerQuestionFragment extends Fragment {
    private static final String ARG_QUESTION_TEXT = "questionText";

    //Widgets
    private String fillInQuestion = null;
    private TextView question; //the question itself
    private Button answerButton;
    private EditText answerBox;


    /**
     *
     */
    public static AnswerQuestionFragment newInstance(String question) {
        AnswerQuestionFragment fragment = new AnswerQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION_TEXT, question);
        fragment.setArguments(args);
        return fragment;
    }

    public AnswerQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fillInQuestion = getArguments().getString(ARG_QUESTION_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_answer_question, container, false);
        //Instantiante widgets
        question = (TextView) view.findViewById(R.id.questionDisplay);
        answerButton = (Button) view.findViewById(R.id.answerButton);
        answerBox = (EditText) view.findViewById(R.id.answerBox);
        question.setText(fillInQuestion);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ////KAD frag logic goes here basically

        //set callback -- go back to "Display Question" screen
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int commit = getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, DisplayQuestionFragment.newInstance(answerBox.getText().toString(), question.getText().toString()))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
