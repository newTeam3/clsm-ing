package com.springboot.management.vo;
/*
 *@Author 左创源
 * @date 2020/04/12
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sort {
    private int id;
    private String sortName;
    private int status;
    private String remark;
}
