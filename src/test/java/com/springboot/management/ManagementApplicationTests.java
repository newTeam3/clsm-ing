package com.springboot.management;

import com.springboot.management.mapper.UserMapper;
import com.springboot.management.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ManagementApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        UserVO user = userMapper.getUserByName("admin");
        System.out.println(user);

        String encode = passwordEncoder.encode("admin");
        System.out.println(encode);

    }

}
