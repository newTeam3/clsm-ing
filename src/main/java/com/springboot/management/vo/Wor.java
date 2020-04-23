package com.springboot.management.vo;

public class Wor {
    private  Integer id;
    private  String  questions;
    private  String  question;
    private  String  answer;
    private  Integer bankId;



    @Override
    public String toString() {
        return "Wor{" +
                "id=" + id +
                ", questions='" + questions + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", bankId=" + bankId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
}
