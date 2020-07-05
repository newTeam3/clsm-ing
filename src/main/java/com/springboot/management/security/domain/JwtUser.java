package com.springboot.management.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
/*
 *@Author 左创源
 * @date 2020/04/18
 *用于安全校验的用户类
 */
public class JwtUser implements UserDetails{

    private final Integer id;
    private final String username;
    private final String password;
    private final String name;
    private final String img;
    private final Date lastPasswordResetDate;
    private final boolean enabled;
    private final int status;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Integer id, String username, String password,String name,String img, Date lastPasswordResetDate, boolean enabled,int status, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name=name;
        this.img = img;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.enabled = enabled;
        this.status=status;
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public int getStatus() {
        return status;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
