package com.springboot.management.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *@Author 左创源
 * @date 2020/04/15
 *
 */
//将明文密码加密
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}