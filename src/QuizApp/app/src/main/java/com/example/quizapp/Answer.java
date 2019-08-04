package com.example.quizapp;

public class Answer {
    private int Answer1;
    private int Answer2;
    private int Answer3;
    private int Answer4;

    public Answer(int answer1, int answer2, int answer3, int answer4) {
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
    }

    public int getAnswer1() {
        return Answer1;
    }

    public void setAnswer1(int answer1) {
        Answer1 = answer1;
    }

    public int getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(int answer2) {
        Answer2 = answer2;
    }

    public int getAnswer3() {
        return Answer3;
    }

    public void setAnswer3(int answer3) {
        Answer3 = answer3;
    }

    public int getAnswer4() {
        return Answer4;
    }

    public void setAnswer4(int answer4) {
        Answer4 = answer4;
    }
}
