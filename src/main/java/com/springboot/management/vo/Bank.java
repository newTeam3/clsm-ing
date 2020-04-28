package com.springboot.management.vo;


public class Bank {
    private  Integer id;
    private  String  name;
    private  String  explain1;
    private  Integer bankCount;

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", explain='" + explain1 + '\'' +
                ", bankCount=" + bankCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain1;
    }

    public void setExplain(String explain1) {
        this.explain1 = explain1;
    }

    public Integer getBankCount() {
        return bankCount;
    }

    public void setBankCount(Integer bankCount) {
        this.bankCount = bankCount;
    }
}
