package com.springboot.management.vo;
/*
 *@Author 左创源
 * @date 2020/04/12
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int id;
    private String title;
    private String content;
    private UserVO userVO;
    private int status;
    private Date time;
    private int quanity;
    private int state;
}
