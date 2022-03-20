package ru.titov.spring;

import java.util.List;

public class Question {

    private String text;
    private  int answer;
    private int correctanswer;
    private List<String> answers;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(int correctanswer) {
        this.correctanswer = correctanswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }


    public int checkCorrect(int answer){
        if(answer == this.correctanswer)
        {
         return 1;
        }
        {
         return 0;
        }
    }

    public Question() {

    }

    public Question(String text, int correctanswer, List<String> answers) {
        this.text = text;
        this.correctanswer = correctanswer;
        this.answers = answers;
    }
}
