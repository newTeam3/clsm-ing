package com.springboot.management.security.domain;

import com.springboot.management.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
/*
 *@Author 左创源
 * @date 2020/04/18
 *返回给前端的token
 */
public class JwtAuthenticationResponse implements Serializable {
  private static final long serialVersionUID = 4784951536404964122L;
  private final String token;
  private UserDetails userVO;
  public JwtAuthenticationResponse(String token,UserDetails userVO) {
    this.token = token;
    this.userVO=userVO;
  }

  public JwtAuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }

  public UserDetails getUserVO() {
    return userVO;
  }
}
