package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluate {
    private int id;
    private String content;
    private Message message;
    private UserVO userVO;
    private Date time;
    private int status;
}
