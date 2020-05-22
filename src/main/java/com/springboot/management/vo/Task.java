package com.springboot.management.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private int id;
    private UserVO userVO;
    private String content;
    private Date createTime;
    private Date deadline;
    private int sort;
    private int status;
    private int count;
}
