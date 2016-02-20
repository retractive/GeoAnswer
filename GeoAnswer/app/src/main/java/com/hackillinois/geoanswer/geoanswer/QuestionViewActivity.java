package com.hackillinois.geoanswer.geoanswer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Screen displays the question at the top, followed by a list of answers. KAD
 */
public class QuestionViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);

        //Get question display fragment
        int commit = getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, DisplayQuestionFragment.newInstance(null))
                .addToBackStack(null)
                .commit();
    }


}
