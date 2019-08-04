package com.example.quizapp;

public class Question {
    private int mQuestion;
    private int mAnswer;

    public Question(int mQuestion, int mAnswer) {
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public int getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(int mAnswer) {
        this.mAnswer = mAnswer;
    }
}
