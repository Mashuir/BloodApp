package com.example.user.bloodapp;


public class FeedBackModelClass {
     private String feedback;
     private String feedBackId;

    public FeedBackModelClass(){

    }

    public FeedBackModelClass(String feedback, String feedBackId) {
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
