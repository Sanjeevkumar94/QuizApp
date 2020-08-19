package com.example.quizapp.model;

public class ListModel {
    String question;
    Boolean isBackgroundColor;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getBackgroundColor() {
        return isBackgroundColor;
    }

    public void setBackgroundColor(Boolean backgroundColor) {
        isBackgroundColor = backgroundColor;
    }



    public ListModel(String question, Boolean isBackgroundColor) {
        this.question = question;
        this.isBackgroundColor = isBackgroundColor;
    }

}
