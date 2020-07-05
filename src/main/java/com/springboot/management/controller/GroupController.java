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
/*
 *@Author 聂精威
 * @date 2020/05/04
 * 项目小组模块的增删改查
 */

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    //获取所有小组
    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = groupService.findAll(pageVO);
        return ResponseEntity.ok(pageInfo);
    }

    //添加一个小组
    @PostMapping(value = "/addGroup")
    public ResponseEntity<?> addGroup(@RequestBody Groups groups) {
        groupService.addGroup(groups);
        return ResponseEntity.ok("操作成功");
    }
    //修改一个小组
    @PostMapping(value = "/updateGroup")
    public ResponseEntity<?> updateGroup(@RequestBody Groups groups) {
        groupService.updateGroup(groups);
        return ResponseEntity.ok("操作成功");
    }
    //单个小组的启用及禁用
    @PostMapping(value = "/banGroup")
    public ResponseEntity<?> banCollege(@RequestBody Groups groups) {
        groupService.banGroup(groups);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用小组
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        groupService.banRows(list);
        return ResponseEntity.ok("操作成功");
    }

}
