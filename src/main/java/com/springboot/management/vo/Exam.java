package com.springboot.management.vo;

public class Exam {
    private  Integer  id;
    private  Integer  uid;
    private  String   username;
    private  Integer  paperid;
    private  String   paperName;
    private  Float  score;
    private  Integer  status;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", paperid=" + paperid +
                ", paperName='" + paperName + '\'' +
                ", score=" + score +
                ", status=" + status +
                '}';
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setName(String java) {
    }
}
