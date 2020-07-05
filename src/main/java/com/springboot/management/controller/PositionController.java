package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.PositionService;
import com.springboot.management.vo.Groups;
import com.springboot.management.vo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*
 *@Author 聂精威
 * @date 2020/05/16
 * 用户职务管理模块的控制类
 */

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;
    //查询所有职务
    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = positionService.findAll(pageVO);
        return ResponseEntity.ok(pageInfo);
    }

    //添加职务信息
    @PostMapping(value = "/addPosition")
    public ResponseEntity<?> addPosition(@RequestBody Position position) {
        positionService.addPosition(position);
        return ResponseEntity.ok("操作成功");
    }
    //修改职务信息
    @PostMapping(value = "/updatePosition")
    public ResponseEntity<?> updatePosition(@RequestBody Position position) {
        positionService.updatePosition(position);
        return ResponseEntity.ok("操作成功");
    }
    //单个职务的启用及禁用
    @PostMapping(value = "/banPosition")
    public ResponseEntity<?> banPosition(@RequestBody Position position) {
        positionService.banPosition(position);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用职务
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        positionService.banRows(list);
        return ResponseEntity.ok("操作成功");
    }

}
