package com.springboot.management.vo;

public class Exam {
    private  Integer  id;
    private  Integer  uid;
    private  Integer  paperid;
    private  Integer  score;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", uid=" + uid +
                ", paperid=" + paperid +
                ", score=" + score +
                '}';
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
