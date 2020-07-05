package com.springboot.management.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 *@Author 左创源
 * @date 2020/04/12
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private int id;
    private String name;
    private String remark;
    private int status;
}
