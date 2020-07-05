package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.CollegeService;
import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*
 * 李子湘
 * 4.27
 *学院增删改查的控制层
 * */
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = collegeService.findAll(pageVO);
        return ResponseEntity.ok(pageInfo);
    }

    //添加学院信息
    @PostMapping(value = "/addCollege")
    public ResponseEntity<?> addCollege(@RequestBody College college) {
        collegeService.addCollege(college);
        return ResponseEntity.ok("操作成功");
    }
    //修改学院信息
    @PostMapping(value = "/updateCollege")
    public ResponseEntity<?> updateCollege(@RequestBody College college) {
        collegeService.updateCollege(college);
        return ResponseEntity.ok("操作成功");
    }
    //单个学院的启用及禁用
    @PostMapping(value = "/banCollege")
    public ResponseEntity<?> banCollege(@RequestBody College college) {
        collegeService.banCollege(college);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用学院
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        collegeService.banRows(list);
        return ResponseEntity.ok("操作成功");
    }

}
