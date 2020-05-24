package com.springboot.management.vo;



public class Paper {
    private  Integer  id;
    private  Integer  TotalScore;
    private  String   time;
    private  Integer  bankId;
    private  String   name;
    private  String   paperNum;
    private  Integer  status;
    private  String   paperName;


    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", TotalScore=" + TotalScore +
                ", time='" + time + '\'' +
                ", bankId=" + bankId +
                ", name='" + name + '\'' +
                ", paperNum='" + paperNum + '\'' +
                ", status=" + status +
                ", paperName='" + paperName + '\'' +
                '}';
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(Integer totalScore) {
        TotalScore = totalScore;
    }

    public String getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(String paperNum) {
        this.paperNum = paperNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
}
