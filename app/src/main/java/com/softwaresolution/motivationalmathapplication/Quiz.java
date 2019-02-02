package com.softwaresolution.motivationalmathapplication;

public class Quiz {
    String quizId;
    String question;
    String answer;

    public Quiz(){

    }

    public Quiz(String quizId,String question,String answer){
        this.quizId = quizId;
        this.question = question;
        this.answer = answer;
    }

    public String getQuizId() {
        return quizId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
