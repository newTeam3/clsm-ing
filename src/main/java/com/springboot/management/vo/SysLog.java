package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {

    private int id;
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private int executionTime;
    private String method;
}
