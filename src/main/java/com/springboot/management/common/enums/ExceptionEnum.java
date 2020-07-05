package com.springboot.management.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*
 * 左创源
 * 4.16
 *异常的枚举类
 * */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    SERVER_CONGESTION(400,"服务器出错");
    private int code;
    private String msg;
}
