package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.GroupService;
import com.springboot.management.vo.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = groupService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //添加学院信息
    @PostMapping(value = "/addGroup")
    public ResponseEntity<?> addGroup(@RequestBody Groups groups) {
        groupService.addGroup(groups);
        System.out.println(groups);
        return ResponseEntity.ok("操作成功");
    }
    //修改学院信息
    @PostMapping(value = "/updateGroup")
    public ResponseEntity<?> updateGroup(@RequestBody Groups groups) {
        groupService.updateGroup(groups);
        System.out.println(groups);
        return ResponseEntity.ok("操作成功");
    }
    //单个学院的启用及禁用
    @PostMapping(value = "/banGroup")
    public ResponseEntity<?> banCollege(@RequestBody Groups groups) {
        groupService.banGroup(groups);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用学院
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        groupService.banRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

}
