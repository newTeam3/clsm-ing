package com.springboot.management.controller;

import com.springboot.management.security.JwtTokenUtil;
import com.springboot.management.security.domain.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
/*
 *@Author 左创源
 * @date 2020/04/26
 * 通过token，获取当前登录用户的信息
 */
/**
 * 获取已授权用户信息
 *
 *
 */
@RestController
public class UserRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  @Qualifier("jwtUserService")
  private UserDetailsService userDetailsService;
  //获取前端传回来的token并解析，获取用户名，并通过用户名查找详细信息
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public JwtUser getAuthenticatedUser(HttpServletRequest request) {
    //获取当前登录用户信息
    String token = request.getHeader(tokenHeader).substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
    return user;
  }

}
