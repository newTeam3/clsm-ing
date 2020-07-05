package com.springboot.management.controller;

import com.springboot.management.service.PaperDetailService;
import com.springboot.management.service.PaperService;
import com.springboot.management.service.WorService;
import com.springboot.management.vo.PaperDetail;
import com.springboot.management.vo.Wor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *@Author 李恒彪
 * @date 2020/04/17
 *
 */
@RestController
@RequestMapping("/answer")
@Slf4j
public class Answer {

    @Autowired
    private WorService worService;
    @Autowired
    private PaperService paperService;

    @Autowired
    private PaperDetailService paperDetailService;
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

    @GetMapping("findAll")
    public Map<String, Object> findAll(Integer uid,Integer paperId){
        HashMap<String, Object> map = new HashMap<>();

        map.put("paperDetail", paperDetailService.findAll(uid,paperId));
        return map;
    }

    @PostMapping("/save1")
    public String save(@RequestParam(value = "uid",required = false) Integer uid, @RequestParam(value = "paperId",required = false) Integer paperId,@RequestBody List<PaperDetail> paperDetail) {
//        log.info("uid这是"+uid);
        int flag=1;
        for (PaperDetail list:paperDetail){
            list.setUid(uid);
            list.setPaperId(paperId);
            list.setWorid(list.getId());
//            log.info("收到的paperDetail" + list);
            List<PaperDetail> all = paperDetailService.findAll(list.getUid(), list.getPaperId());
              if (all.isEmpty()){
                  flag=0;
              }else {
                  flag=2;
              }

        }
       log.info("flag="+flag);
        if (paperDetail!=null) {
            if (flag==0){
                paperDetailService.save(paperDetail);
                return "success";
            }
            else if (flag==2){
                paperDetailService.update(paperDetail);
                return "update";
            }
            else {
                return "fail1";
            }


        }else {
            return "fail";
        }
    }

    @PostMapping("/update")
    public String update(@RequestBody PaperDetail paperDetail){
        if (paperDetail!=null) {
//            paperDetailService.update(paperDetail);
            return "success";
        }else {
            return "fail";
        }
    }

}
