package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private Date time;
    private String work;
    private String problem;
    private String solve;
    private String summary;
    private String plan;
    private UserVO userVO;
    private Task task;
    private int status;
    private int state;

}
