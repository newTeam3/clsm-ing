package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
/*
 *@Author 左创源
 * @date 2020/04/12
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;
    private Integer aid;
    private Integer uid;
    private Integer pid;
    private String title;
    private String img;
    private String name;
    private String content;
    private Date time;
    private List<Comment> child;

}
