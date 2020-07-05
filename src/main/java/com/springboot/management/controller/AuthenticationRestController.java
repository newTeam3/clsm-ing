package com.springboot.management.controller;

import com.springboot.management.security.JwtTokenUtil;
import com.springboot.management.security.domain.AuthenticationException;
import com.springboot.management.security.domain.JwtAuthenticationRequest;
import com.springboot.management.security.domain.JwtAuthenticationResponse;
import com.springboot.management.security.domain.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/*
 * 左创源
 * 4.26
 *授权管理器
 * */
@RestController
public class AuthenticationRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  @Qualifier("jwtUserService")
  private UserDetailsService userDetailsService;

  /**
   * 创建授权令牌 (登录)
   *
   * @param authenticationRequest
   * @return
   */
  @PostMapping(value = "${jwt.route.authentication.path}")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
    //校验用户名密码是否正确
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtAuthenticationResponse(token,userDetails));
  }

  /**
   * 刷新
   * @param request
   * @return
   */
  @GetMapping(value = "${jwt.route.authentication.refresh}")
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String authToken = request.getHeader(tokenHeader);
    final String token = authToken.substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

  @ExceptionHandler({AuthenticationException.class})
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }


  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      //校验用户名密码是否正确
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("账户不可用", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("坏的凭据!", e);
    }
  }

}
