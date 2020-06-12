package com.springboot.management.vo;/*
 *@Author lee
 * @date 2020/06/11
 */

public class PaperDetail {
    private  Integer id;
    private  Integer  uid;
    private  Integer  worid;
    private  Integer  paperId;
    private  String  questions;
    private  String  question;
    private  String  answer;
    private  String  name;
    private  String  options;
    private  String  optionA;
    private  String  optionB;
    private  String  optionC;
    private  String  optionD;


    @Override
    public String toString() {
        return "PaperDetail{" +
                "id=" + id +
                ", uid=" + uid +
                ", worid=" + worid +
                ", paperId=" + paperId +
                ", questions='" + questions + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", name='" + name + '\'' +
                ", options='" + options + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                '}';
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getWorid() {
        return worid;
    }

    public void setWorid(Integer worid) {
        this.worid = worid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
