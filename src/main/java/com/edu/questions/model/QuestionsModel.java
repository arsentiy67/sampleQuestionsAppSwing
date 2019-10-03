package com.edu.questions.model;

public class QuestionsModel {

    private final Questions questions;

    public QuestionsModel(Questions questions) {
        this.questions = questions;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
    }
}
