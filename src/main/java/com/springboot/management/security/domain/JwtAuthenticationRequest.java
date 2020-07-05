package com.springboot.management.security.domain;

import java.io.Serializable;
/*
 *@Author 左创源
 * @date 2020/04/18
 *封装接收的用户名和密码
 */
public class JwtAuthenticationRequest implements Serializable {

  private static final long serialVersionUID = -8445943548965154778L;

  private String username;
  private String password;

  public JwtAuthenticationRequest() {
    super();
  }

  public JwtAuthenticationRequest(String username, String password) {
    this.setUsername(username);
    this.setPassword(password);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
