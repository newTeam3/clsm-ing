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
/*
 *@Author 李明良
 * @date 2020/05/18
 * 日周报模块的控制类
 */

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    //查询所有日周报
    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = messageService.findAll(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //通过报告id查询老师的评语
    @GetMapping(value = "/findEvaluateByMid")
    public ResponseEntity<?> findEvaluateByMid(@RequestParam("mid") int mid) {
        List<Evaluate> list = messageService.findEvaluateByMid(mid);
        return ResponseEntity.ok(list);
    }
    //老师在后台提交报告评语
    @PostMapping(value = "/evaluate")
    public ResponseEntity<?> evaluate(@RequestBody Evaluate evaluate) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        evaluate.setTime(timestamp);
        messageService.evaluate(evaluate);
        return ResponseEntity.ok("操作成功");
    }
    //禁用单个报告
    @PostMapping(value = "/banMessage")
    public ResponseEntity<?> banMessage(@RequestBody Message message) {
        messageService.banMessage(message);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用报告
    @GetMapping(value = "/banMessageRows")
    public ResponseEntity<?> banMessageRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        messageService.banMessageRows(list);
        return ResponseEntity.ok("操作成功");
    }
    //通过报告类型得到所有的报告发布任务
    @GetMapping(value = "/getContentAll")
    public ResponseEntity<?> getContentAll(@RequestParam("sort") int sort) {
        List<Task> list = messageService.getContentAll(sort);
        return ResponseEntity.ok(list);
    }
    //查住所有周报
    @PostMapping(value = "/findAllWeekReport")
    public ResponseEntity<?> findAllWeekReport(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = messageService.findAllWeekReport(pageVO);
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
    //查询报告详情
    @GetMapping(value = "/getMessageItem")
    public ResponseEntity<?> getMessageItem(@RequestParam("id") int id) {
        Message message=messageService.getMessageItem(id);
        return ResponseEntity.ok(message);
    }
    //通过用户id查询报告
    @PostMapping(value = "/getMessageByUid")
    public ResponseEntity<?> getMessageByUid(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = messageService.getMessageByUid(pageVO);
        return ResponseEntity.ok(pageInfo);
    }

}
