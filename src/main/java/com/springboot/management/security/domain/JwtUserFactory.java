package com.springboot.management.security.domain;

import com.springboot.management.vo.RoleVO;
import com.springboot.management.vo.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用工厂模式创建JwtUser
 */
public class JwtUserFactory {

    public static JwtUser create(UserVO user){
        return new JwtUser(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getLastPasswordResetDate(),
                user.getStatus()==1?true:false,
                mapToAuthority(user.getRoles()));
    }

    private static Collection<? extends GrantedAuthority> mapToAuthority(List<RoleVO> authorities){
        return authorities.stream().map(authority ->
                new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
    }
}

