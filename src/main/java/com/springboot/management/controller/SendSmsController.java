package com.springboot.management.controller;

import com.springboot.management.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/*
 *@Author 左创源
 * @date 2020/04/26
 * 发送短信验证码并存储验证码到redis
 */


@RestController
@RequestMapping("/sms")
public class SendSmsController {
    @Autowired
    private SendSms sendSms;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //接受手机号，生成验证码并发送到手机号，发送成功存入redis
    @GetMapping("/send")
    public ResponseEntity<?> code(@RequestParam("phone") String phone){
         String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return ResponseEntity.ok("exist");
        }
        //生成验证码
         code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<Object, Object> param = new HashMap<>();
        param.put("code",code);
        boolean flag = sendSms.sendSms(phone, param);
        if(flag){
            //在redis中存放验证码和手机号，设置五分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("error");
        }

    }
    //校验前端输入的验证码和redis中存放的验证码是否一致
    @GetMapping(value = "/checkCode")
    public ResponseEntity<?> checkCode(@RequestParam("code") String code,@RequestParam("phone") String phone) {
        String scode = redisTemplate.opsForValue().get(phone);
        System.out.println(scode);
        if(code.equals(scode)){
            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.ok("error");
        }

    }
}
