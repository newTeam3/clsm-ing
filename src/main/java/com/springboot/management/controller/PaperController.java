package com.springboot.management.controller;

import com.springboot.management.mapper.BankDao;
import com.springboot.management.service.PaperService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Exam;
import com.springboot.management.vo.Paper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paper")
@Slf4j
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private BankDao bankDao;
    //查询所有
    @GetMapping("/findAllPaper")
    public Map<String, Object> findBuPage(Integer page, Integer rows) {
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Paper> papers = paperService.findByPage(page, rows);
        Integer totals = paperService.findTotals();
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("papers", papers);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
    @PostMapping("/save")
    public String save(@RequestBody Paper paper) {
       log.info("收到的paper" + paper);
        Bank byBankName = bankDao.findByBankName(paper.getName());
        Paper paper1 = paperService.findByBankId(byBankName.getId());
        if (paper1==null){
            try {
                paperService.save(paper);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        }else {
            return "repeat";
        }
    }
    @GetMapping("/findOne")
    public Paper findOne(Integer id) {

        return paperService.findOne(id);
    }
    //修改
    @PostMapping("/update")
    public String update(@RequestBody Paper paper) {
        try {
            paperService.update(paper);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @PostMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) {
        try {
            paperService.updateStatus(id,status);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //根据关键字
    @PostMapping("/findByNameOrScore")
    public Map<String, Object> findByNameOrScore(@RequestParam(value = "page",required = false ,defaultValue = "1") Integer page, Integer rows, @RequestBody Paper paper) {
        log.info("收到的paper" + paper);
        log.info("page" + page);
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Paper> papers = paperService.findTimeOrName(page,rows,paper);
        Integer totals = paperService.totalsSelect(paper);
        log.info("多少页"+totals);
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("papers", papers);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
}
