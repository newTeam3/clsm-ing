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
/*
 *@Author 王立维
 * @date 2020/05/09
 */

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    //得到所有发布的提问
    @PostMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = questionService.findAll(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //回复一个提问
    @PostMapping(value = "/reply")
    public ResponseEntity<?> reply(@RequestBody Answer answer) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        answer.setTime(timestamp);
        questionService.reply(answer);
        return ResponseEntity.ok("操作成功");
    }
    //通过提问的id搜索所有回复
    @GetMapping(value = "/findAnswerByQid")
    public ResponseEntity<?> findAnswerByQid(@RequestParam("qid") int qid) {
        List<Answer> list = questionService.findAnswerByQid(qid);
        return ResponseEntity.ok(list);
    }
    //禁用单个提问帖子
    @PostMapping(value = "/banQuestion")
    public ResponseEntity<?> banQuestion(@RequestBody Question question) {
        questionService.banQuestion(question);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用提问的帖子
    @GetMapping(value = "/banRows")
    public ResponseEntity<?> banRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        questionService.banRows(list);
        return ResponseEntity.ok("操作成功");
    }
    //查询所有提问的回复
    @PostMapping(value = "/findAllAnswer")
    public ResponseEntity<?> findAllAnswer(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = questionService.findAllAnswer(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //禁用回答
    @PostMapping(value = "/banAnswer")
    public ResponseEntity<?> banAnswer(@RequestBody Answer answer) {
        questionService.banAnswer(answer);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用回答
    @GetMapping(value = "/banAnswerRows")
    public ResponseEntity<?> banAnswerRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        questionService.banAnswerRows(list);
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
    //查找提问的回答
    @PostMapping(value = "/findRequestionComment")
    public ResponseEntity<?> findRequestionComment(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = questionService.findRequestionComment(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
}
