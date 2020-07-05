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
