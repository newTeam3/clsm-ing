package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int id;
    private String title;
    private String content;
    private Date createTime;
    private int uid;
    private String name;
    private int quantity;
    private int sid;
    private String sortName;
    private int status;
}
