package com.example.user.bloodapp;

/**
 * Created by User on 3/22/2018.
 */

public class FeedBackModelClass {
     private String feedback;
     private String feedBackId;

    public FeedBackModelClass(){

    }

    private FeedBackModelClass(String feedback, String feedBackId) {
        this.feedback = feedback;
        this.feedBackId = feedBackId;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getFeedBackId() {
        return feedBackId;
    }
}
