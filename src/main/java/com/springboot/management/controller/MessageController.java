package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.MessageService;
import com.springboot.management.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = messageService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    @GetMapping(value = "/findEvaluateByMid")
    public ResponseEntity<?> findEvaluateByMid(@RequestParam("mid") int mid) {
        List<Evaluate> list = messageService.findEvaluateByMid(mid);
        System.out.println("这是list" + list);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/evaluate")
    public ResponseEntity<?> evaluate(@RequestBody Evaluate evaluate) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        evaluate.setTime(timestamp);
        messageService.evaluate(evaluate);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/banMessage")
    public ResponseEntity<?> banMessage(@RequestBody Message message) {
        messageService.banMessage(message);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/banMessageRows")
    public ResponseEntity<?> banMessageRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        messageService.banMessageRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/getContentAll")
    public ResponseEntity<?> getContentAll(@RequestParam("sort") int sort) {
        List<Task> list = messageService.getContentAll(sort);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/findAllWeekReport")
    public ResponseEntity<?> findAllWeekReport(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = messageService.findAllWeekReport(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //提交报告
    @PostMapping(value = "/commit")
    public ResponseEntity<?> commit(@RequestBody Message message) {
        System.out.println("这是pagevo"+message);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        message.setTime(timestamp);
        messageService.commit(message);
        return ResponseEntity.ok("操作成功");
    }

}
