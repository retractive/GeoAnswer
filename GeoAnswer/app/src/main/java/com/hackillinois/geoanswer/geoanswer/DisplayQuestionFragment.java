package com.hackillinois.geoanswer.geoanswer;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Use the {@link DisplayQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayQuestionFragment extends Fragment {
    private static final String ARG_USER_SUBMISSION = "questionText";
    private static final String ARG_ANSWER_TEXT = "answerText";

    private String newestAnswer = null;
    private String questionClicked = null;

   // private String exampleQ = "What ice cream flavors are at Babcock today?";
    //private String exampleUser = "John Smith";
    private String defaultAnswer = "Got an answer? Submit your own...";

    //Widgets
    private ListView answerList; //the answers to this question
    private TextView question; //the question itself
    private ArrayList<String> answers;
    private ArrayAdapter<String> adapter;
    private Button answerButton;

    /**
     *
     */
    public static DisplayQuestionFragment newInstance(String answerText, String question) {
        DisplayQuestionFragment fragment = new DisplayQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ANSWER_TEXT, answerText);
        args.putString(ARG_USER_SUBMISSION, question);
        fragment.setArguments(args);
        return fragment;
    }

    public DisplayQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newestAnswer = getArguments().getString(ARG_ANSWER_TEXT);
            questionClicked = getArguments().getString(ARG_USER_SUBMISSION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = null;
        view = inflater.inflate(R.layout.fragment_display_question, container, false);
        //Instantiante widgets
        answerList = (ListView) view.findViewById(R.id.answerList);
        question = (TextView) view.findViewById(R.id.questionDisplay);

        // get QuestionList from main QVActivity
        QuestionViewActivity test = (QuestionViewActivity) getActivity();
        int questionIndex = test.getQuestionList().indexOf(questionClicked);  //Question feed
        answers = test.getAnswerList().get(0);


        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, answers);
        answerList.setAdapter(adapter);

        answerButton = (Button) view.findViewById(R.id.answerButton);

        //Display question
        question.setText(questionClicked);

        //Default answer
        answers.add(defaultAnswer);

        if(newestAnswer != null){
            answers.add(newestAnswer);
        }

   return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //set callback --> go to "Answer Question" screen
        answerButton.setOnClickListener(new View.OnClickListener() {

            String q = question.getText().toString();
            @Override
            public void onClick(View v) {
                int commit = getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, AnswerQuestionFragment.newInstance(q))
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}