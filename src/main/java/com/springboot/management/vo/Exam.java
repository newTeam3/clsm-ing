package com.springboot.management.vo;

public class Exam {
    private  Integer  id;
    private  Integer  uid;
    private  String   username;
    private  Integer  paperid;
    private  String   name;
    private  Integer  score;
    private  Integer  status;


    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", paperid=" + paperid +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", status=" + status +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
