package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.TaskService;
import com.springboot.management.vo.Message;
import com.springboot.management.vo.Notice;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = taskService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //添加公告信息
    @PostMapping(value = "/addNotice")
    public ResponseEntity<?> addNotice(@RequestBody Notice notice) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        notice.setTime(timestamp);
        taskService.addNotice(notice);
        return ResponseEntity.ok("操作成功");
    }
    //修改公告信息
    @PostMapping(value = "/updateNotice")
    public ResponseEntity<?> updateNotice(@RequestBody Notice notice) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        notice.setTime(timestamp);
        taskService.updateNotice(notice);
        return ResponseEntity.ok("操作成功");
    }
    //单个公告的启用及禁用
    @PostMapping(value = "/banNotice")
    public ResponseEntity<?> banNotice(@RequestBody Notice notice) {
        taskService.banNotice(notice);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用公告
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        taskService.banRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/findAllTask")
    public ResponseEntity<?> findAllTask(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = taskService.findAllTask(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    //添加任务信息
    @PostMapping(value = "/addTask")
    public ResponseEntity<?> addTask(@RequestBody Task task) throws ParseException {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        task.setCreateTime(timestamp);
        taskService.addTask(task);
        return ResponseEntity.ok("操作成功");
    }
    //修改任务信息
    @PostMapping(value = "/updateTask")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        task.setCreateTime(timestamp);
        taskService.updateTask(task);
        return ResponseEntity.ok("操作成功");
    }
    //单个任务的启用及禁用
    @PostMapping(value = "/banTask")
    public ResponseEntity<?> banTask(@RequestBody Task task) {
        taskService.banTask(task);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用任务
    @GetMapping(value = "/banTaskRows")
    public ResponseEntity<?> banTaskRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        taskService.banTaskRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/findCommitData")
    public ResponseEntity<?> findCommitData(@RequestParam("id") int id) {
        Map<String, Object> map = taskService.findCommitData(id);
        System.out.println("map" +map);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value = "/checkTask")
    public ResponseEntity<?> checkTask(@RequestParam("uid") int uid,@RequestParam("tid") int tid) {

        boolean flag=taskService.checkTask(uid,tid);
        return ResponseEntity.ok(flag);
    }

}
