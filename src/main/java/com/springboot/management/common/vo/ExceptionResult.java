package com.springboot.management.common.vo;

import com.springboot.management.common.enums.ExceptionEnum;
import lombok.Data;
/*
 * 左创源
 * 4.16
 *异常实体类
 * */
@Data
public class ExceptionResult {

    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
