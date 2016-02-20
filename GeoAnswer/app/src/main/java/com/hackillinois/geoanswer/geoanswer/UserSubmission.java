package com.hackillinois.geoanswer.geoanswer;

/**
 * Created by willa on 2/20/16.
 */
public class UserSubmission {

    // TODO: Implement components, getters and setters,
    public String questionText;
    public String userPosted;
   // public boolean answered;

    public UserSubmission(String userName, String question){
        userPosted = userName;
        questionText = question;
    }

public String toString(){
//    if (userPosted == null){
//        return questionText;
//    }
    //return "user " + userPosted + " wants to know..\n" + questionText;
    return questionText;
}

}
