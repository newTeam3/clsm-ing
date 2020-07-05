package com.springboot.management.vo;
/*
 *@Author 李恒彪
 * @date 2020/04/14
 *
 */

public class Bank {
    private  Integer id;
    private  String  name;
    private  String  explain1;
    private  Integer bankCount;
    private  Integer status;


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", explain1='" + explain1 + '\'' +
                ", bankCount=" + bankCount +
                ", status=" + status +
                '}';
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExplain1() {
        return explain1;
    }

    public void setExplain1(String explain1) {
        this.explain1 = explain1;
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


    public Integer getBankCount() {
        return bankCount;
    }

    public void setBankCount(Integer bankCount) {
        this.bankCount = bankCount;
    }
}
