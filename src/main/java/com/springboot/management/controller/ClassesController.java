package com.springboot.management.controller;


import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.ClassesService;
import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    //分页查询班级信息
    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = classesService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }
    //查询所有学院
    @PostMapping(value = "/findAllCollege")
    public ResponseEntity<?> findAllCollege() {
        List<College> list=classesService.findAllCollege();
        System.out.println(list);
        return ResponseEntity.ok(list);
    }
    //添加班级信息
    @PostMapping(value = "/addClasses")
    public ResponseEntity<?> addClasses(@RequestBody Classes classes) {
        classesService.addClasses(classes);
        System.out.println(classes);
        return ResponseEntity.ok("操作成功");
    }
    //修改班级信息
    @PostMapping(value = "/updateClasses")
    public ResponseEntity<?> updateClasses(@RequestBody Classes classes) {
        classesService.updateClasses(classes);
        System.out.println(classes);
        return ResponseEntity.ok("操作成功");
    }
    //单个班级的启用及禁用
    @PostMapping(value = "/banClasses")
    public ResponseEntity<?> banClasses(@RequestBody Classes classes) {
        classesService.banClasses(classes);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用班级
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam(value = "ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        classesService.banRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }


}
