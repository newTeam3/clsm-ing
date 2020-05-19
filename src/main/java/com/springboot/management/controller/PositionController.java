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

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = positionService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //添加学院信息
    @PostMapping(value = "/addPosition")
    public ResponseEntity<?> addPosition(@RequestBody Position position) {
        positionService.addPosition(position);
        System.out.println(position);
        return ResponseEntity.ok("操作成功");
    }
    //修改学院信息
    @PostMapping(value = "/updatePosition")
    public ResponseEntity<?> updatePosition(@RequestBody Position position) {
        positionService.updatePosition(position);
        System.out.println(position);
        return ResponseEntity.ok("操作成功");
    }
    //单个学院的启用及禁用
    @PostMapping(value = "/banPosition")
    public ResponseEntity<?> banPosition(@RequestBody Position position) {
        positionService.banPosition(position);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用学院
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        positionService.banRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

}
