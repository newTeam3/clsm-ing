package com.springboot.management.controller;

import com.springboot.management.service.BankService;
import com.springboot.management.service.PaperService;
import com.springboot.management.service.WorService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Paper;
import com.springboot.management.vo.Wor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/answer")
@Slf4j
public class Answer {

    @Autowired
    private WorService worService;
    @Autowired
    private PaperService paperService;
    @GetMapping("/AnswerAll")
    public Map<String, Object> AnswerAll(String paperNum,@RequestParam(value = "size",required = false ,defaultValue = "4")Integer rows, Integer bankId){
        HashMap<String, Object> map = new HashMap<>();
        log.info("收到的paperNum" + paperNum);
        log.info("收到的bankId" + bankId);
        String[] c = paperNum.split(",");
        List<Wor> wors = new ArrayList<Wor>();
        for (String ss : c){
            Wor one = worService.findByNumber(Integer.valueOf(ss),bankId);
            wors.add(one);
        }
        map.put("wors",wors);
        return map;
    }
}
