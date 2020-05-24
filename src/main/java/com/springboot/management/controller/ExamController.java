package com.springboot.management.controller;

import com.springboot.management.mapper.BankDao;
import com.springboot.management.mapper.PaperDao;
import com.springboot.management.mapper.UserMapper;
import com.springboot.management.service.ExamService;
import com.springboot.management.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam")
@Slf4j
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/findAllExam")
    public Map<String, Object> findBuPage( @RequestParam(value = "page",required = false ,defaultValue = "1") Integer page,@RequestParam(value = "size",required = false ,defaultValue = "4") Integer rows,@RequestParam(value = "username") String username,@RequestParam(value = "name") String name) {
        log.info("收到的" + page);
        log.info("收到的" + username);
        log.info("收到的" + name);
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Exam> exams = examService.findByPage(page, rows,name);
        UserVO userByName = userMapper.getUserByName(username);
        Integer totals = examService.findTotals(userByName.getId());
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("exams", exams);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }

    @PostMapping("/save")
    public String save(@RequestBody Exam exam) {
//        log.info("收到的" + exam);
        Paper byBankName = paperDao.findByPaperName(exam.getPaperName());
        UserVO userByName = userMapper.getUserByName(exam.getUsername());
        Exam uIdAndPaperId = examService.findByUIdAndPaperId(userByName.getId(), byBankName.getId());
//        log.info("收到的" + uIdAndPaperId);
         if (byBankName==null){
             return "fail1";
         }else if (userByName==null){
            return "fail2";
        }else if (uIdAndPaperId== null) {
             exam.setPaperid(byBankName.getId());
             exam.setUid(userByName.getId());
            try {
                examService.save(exam);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        } else {
            exam.setId(uIdAndPaperId.getId());
            examService.update(exam);
            return "update";
        }
    }
    @GetMapping("/findOne")
    public Exam findOne(Integer id) {

        return examService.findOne(id);
    }

    //修改
    @PostMapping("/update")
    public String update(@RequestBody Exam exam) {
        try {
            examService.update(exam);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) {


        try {
            examService.updateStatus(id,status);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //根据关键字
    @PostMapping("/findByNameOrScore")
    public Map<String, Object> findByNameOrScore(@RequestParam(value = "page",required = false ,defaultValue = "1") Integer page, @RequestParam(value = "size",required = false ,defaultValue = "4") Integer rows, @RequestBody Exam exam) {
//        log.info("收到的exam" + exam);
        log.info("page" + page);
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Exam> exams = examService.findByNameOrScore(page,rows,exam);
        Integer totals = examService.totalsSelect(exam);
        log.info("多少页"+totals);
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("exams", exams);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
}
