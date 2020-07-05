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
public class Answer {
    private int id;
    private String content;
    private Date time;
    private UserVO userVO;
    private Question question;
    private int status;
}
