package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.LogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;

    @DeleteMapping("deleteId/{id}")
    @ApiOperation(value = "日志删除")
    public ResponseEntity<?> deleteById(@ApiParam("日志id") @PathVariable("id") Integer id){
        logService.deletById(id);
        return ResponseEntity.ok("操作成功");
    }

    @ApiOperation(value = "日志批量删除")
    @DeleteMapping("deleteIds")
    public ResponseEntity<?> deleteByIds(@ApiParam("日志ids") @RequestBody List<Integer> ids){
        logService.deletByIds(ids);
        return ResponseEntity.ok("操作成功");
    }

    @ApiOperation(value = "日志分页查询")
    @PostMapping("all")
    public ResponseEntity<?> findAllByPage(@RequestBody PageVO pageVO){
        PageInfo pageInfo = logService.findAllByPage(pageVO);
        return ResponseEntity.ok(pageInfo);
    }


}
