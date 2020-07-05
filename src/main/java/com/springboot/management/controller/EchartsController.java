package com.springboot.management.controller;

import com.springboot.management.service.EchartsService;
import com.springboot.management.vo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/*
 * 杨伟棋
 * 5.6
 *获取echarts报表所需要的数据
 * */
@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    EchartsService echartsService;
    //得到每个学院的班级数量
    @GetMapping("/getClasses")
    public ResponseEntity<?> getClasses() {
        List<Map<String,Object>> list = echartsService.getClasses();
        return ResponseEntity.ok(list);
    }
    //获取男女性别数量
    @GetMapping("/getSex")
    public ResponseEntity<?> getSex() {
        List<Map<String,Object>> list = echartsService.getSex();
        return ResponseEntity.ok(list);
    }
}
