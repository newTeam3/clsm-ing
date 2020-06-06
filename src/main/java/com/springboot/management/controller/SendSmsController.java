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


@RestController
@RequestMapping("/sms")
public class SendSmsController {
    @Autowired
    private SendSms sendSms;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @GetMapping("/send")
    public ResponseEntity<?> code(@RequestParam("phone") String phone){
         String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return ResponseEntity.ok("exist");
        }
         code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<Object, Object> param = new HashMap<>();
        param.put("code",code);
        boolean flag = sendSms.sendSms(phone, param);
        if(flag){
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            System.out.println("这是验证码"+code);
            return ResponseEntity.ok("success");
        }else {
            return ResponseEntity.ok("error");
        }

    }

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
