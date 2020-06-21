package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.QuestionService;
import com.springboot.management.vo.Answer;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = questionService.findAll(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }
    @PostMapping(value = "/reply")
    public ResponseEntity<?> reply(@RequestBody Answer answer) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        answer.setTime(timestamp);
        questionService.reply(answer);
        System.out.println(answer);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/findAnswerByQid")
    public ResponseEntity<?> findAnswerByQid(@RequestParam("qid") int qid) {
        List<Answer> list = questionService.findAnswerByQid(qid);
        System.out.println("这是list" + list);
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/banQuestion")
    public ResponseEntity<?> banQuestion(@RequestBody Question question) {
        questionService.banQuestion(question);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        questionService.banRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }

    @PostMapping(value = "/findAllAnswer")
    public ResponseEntity<?> findAllAnswer(@RequestBody PageVO pageVO) {
        System.out.println("这是pagevo"+pageVO);
        PageInfo pageInfo = questionService.findAllAnswer(pageVO);
        System.out.println("这是pageinfo"+pageInfo);
        return ResponseEntity.ok(pageInfo);
    }

    @PostMapping(value = "/banAnswer")
    public ResponseEntity<?> banAnswer(@RequestBody Answer answer) {
        questionService.banAnswer(answer);
        return ResponseEntity.ok("操作成功");
    }

    @GetMapping(value = "/banAnswerRows")
    public ResponseEntity<?> banAnswerRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        questionService.banAnswerRows(list);
        System.out.println("这是list" + list);
        return ResponseEntity.ok("操作成功");
    }
    //根据id查找问题
    @GetMapping(value = "/findQuestionById")
    public ResponseEntity<?> findQuestionById(@RequestParam("id") int id) {

        Map<String, Object> map = questionService.findQuestionById(id);
        return ResponseEntity.ok(map);
    }
    //前台发布问题
    @PostMapping(value = "/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        question.setTime(timestamp);
        questionService.addQuestion(question);
        return ResponseEntity.ok("操作成功");
    }
}
