package com.springboot.management.vo;
/*
 *@Author 李恒彪
 * @date 2020/04/14
 *
 */
public class Wor {
    private  Integer id;
    private  String  questions;
    private  String  question;
    private  String  answer;
    private  Integer bankId;
    private  Integer status;
    private  String  name;
    private  String  optionA;
    private  String  optionB;
    private  String  optionC;
    private  String  optionD;
    private  Integer number;
    private  Wor  wor;

    @Override
    public String toString() {
        return "Wor{" +
                "id=" + id +
                ", questions='" + questions + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", bankId=" + bankId +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", number=" + number +
                ", wor=" + wor +
                '}';
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Wor getWor() {
        return wor;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
