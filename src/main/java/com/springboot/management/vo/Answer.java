package com.springboot.management.vo;

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
