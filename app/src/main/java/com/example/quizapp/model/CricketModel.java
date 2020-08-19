package com.example.quizapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CricketModel implements Serializable {
    String question;
    ArrayList<String> answers;
    String correctAnswer;


    public CricketModel(String question, ArrayList<String> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
