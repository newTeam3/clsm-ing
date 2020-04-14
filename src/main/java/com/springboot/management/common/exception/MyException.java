package com.springboot.management.common.exception;

import com.springboot.management.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

}
