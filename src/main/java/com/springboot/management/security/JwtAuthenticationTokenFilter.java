package com.springboot.management.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**左创源
 * 2020/04/18
 * JWT 过滤器
 * 校验请求的token是否有效，完成用户授权加载
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

  private final Log logger = LogFactory.getLog(this.getClass());


  private UserDetailsService userDetailsService;

  private JwtTokenUtil jwtTokenUtil;

  private String tokenHeader;

  public JwtAuthenticationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, String tokenHeader) {
    this.userDetailsService = userDetailsService;
    this.jwtTokenUtil = jwtTokenUtil;
    this.tokenHeader = tokenHeader;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    //获取token所在属性值
    final String requestHeader = request.getHeader(this.tokenHeader);

    String username = null;
    String authToken = null;
    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
      //获取token
      authToken = requestHeader.substring(7);
      try {
        username = jwtTokenUtil.getUsernameFromToken(authToken);
      } catch (IllegalArgumentException e) {
        logger.error("token不正常", e);
      } catch (ExpiredJwtException e) {
        logger.warn("令牌已过期", e);
      }
    } else {
      logger.warn("不是以Bearer开头");
    }

    logger.info("身份验证" + username);
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      //得到UserDetails对象
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
      //验证token,用户授权认证
      if (jwtTokenUtil.validateToken(authToken, userDetails)) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    chain.doFilter(request, response);
  }
}