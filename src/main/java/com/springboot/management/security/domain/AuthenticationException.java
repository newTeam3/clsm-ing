package com.springboot.management.security.domain;

/*
 *@Author 左创源
 * @date 2020/04/16
 *未授权定义异常类
 */
public class AuthenticationException extends RuntimeException {
  public AuthenticationException(String message, Throwable cause) {
    super(message, cause);
  }
}
