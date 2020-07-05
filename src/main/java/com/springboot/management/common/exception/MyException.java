package com.springboot.management.common.exception;

import com.springboot.management.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*
 * 左创源
 * 4.16
 *自定义全局异常处理
 * */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

}
