package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private int id;
    private UserVO userVO;
    private String content;
    private Date time;
    private int status;
}
