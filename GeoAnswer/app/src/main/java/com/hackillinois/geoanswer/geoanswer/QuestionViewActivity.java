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
public class QuestionViewActivity extends AppCompatActivity
        //implements LocationFeedFragment.Listener
{

    public ArrayList<String> questionList = new ArrayList<String>();
    public ArrayList<ArrayList<String>> answerList = new ArrayList<ArrayList<String>>();
    //private String exampleUser = "John Smith";
    private String defaultQuestion = "Got a question? Submit your own...";

    public ArrayList<String> getQuestionList() {
        return questionList;
    }

    public void addQuestion(String u) {
        questionList.add(u);
        ArrayList<String> temp = new ArrayList<String>();
      //  temp.add("dummy answer");
        answerList.add(temp);
    }

    public ArrayList<ArrayList<String>> getAnswerList(){
        return answerList;
    }

    public void addAnswer (String answer, int questionIndex){
    answerList.get(questionIndex).add(answer);
}

//@Override
//    public void passInfo(ArrayList<UserSubmission> data){
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);
        addQuestion(defaultQuestion);
        String locationName = "HackIllinois";

        LocationFeedFragment frag = LocationFeedFragment.newInstance(locationName, null);
        // frag.setMyListener(this);


        //Get location feed fragment
        int commit = getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, frag)
                .addToBackStack(null)
                .commit();

    }

}
