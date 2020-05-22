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

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    EchartsService echartsService;

    @GetMapping("/getClasses")
    public ResponseEntity<?> getClasses() {
        List<Map<String,Object>> list = echartsService.getClasses();
        System.out.println("list" + list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getSex")
    public ResponseEntity<?> getSex() {
        List<Map<String,Object>> list = echartsService.getSex();
        System.out.println("list" + list);
        return ResponseEntity.ok(list);
    }
}
