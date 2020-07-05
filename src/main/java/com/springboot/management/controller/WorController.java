package com.springboot.management.controller;

import com.springboot.management.mapper.BankDao;
import com.springboot.management.service.BankService;
import com.springboot.management.service.WorService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *@Author 李恒彪
 * @date 2020/04/16
 *
 */
@RestController
@RequestMapping("/wor")
@Slf4j
public class WorController {


    @Autowired
    private WorService worService;

    @Autowired
    private BankService bankService;
    @Autowired
    private BankDao bankDao;


    //查询所有
    @GetMapping("/findAllWor")
    public Map<String, Object> findBuPage(Integer page, Integer rows) {
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Wor> wors = worService.findByPage(page, rows);
        Integer totals = worService.findTotals();
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("wors", wors);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }

    @PostMapping("/save")
    public String save(@RequestBody Wor wor) {
//        log.info("收到的" + wor);
        Wor wor1 = worService.findByQuestion(wor.getQuestion());
        Bank byBankName = bankService.findByBankName(wor.getName());
        if (byBankName == null) {
            return "fail_fail";
        }
        if (wor1 == null) {
            try {
                worService.save(wor);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        } else {
            return "repeat";
        }
    }

    //删除
    @GetMapping("/delete")
    public String delete(String id) {
//        log.info("收到的id" + id);
        try {
            worService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @GetMapping("/findOne")
    public Wor findOne(Integer id) {
        return worService.findOne(id);
    }

    //修改
    @PostMapping("/update")
    public String update(@RequestBody Wor wor) {
        Bank byBankName = bankService.findByBankName(wor.getName());
        if (byBankName == null) {
            return "fail1";
        } else {
            try {
                worService.update(wor);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        }
    }

    @PostMapping("/updateStatus")
    public String updateStatus(Integer id, Integer status) {
        try {
            worService.updateStatus(id, status);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/findQuestionOrName")
    public Map<String, Object> findQuestionOrName(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,  @RequestParam(value = "size",required = false ,defaultValue = "4") Integer rows, @RequestBody Wor wor) {
//        wor.setBankId(bankDao.findByBankName(wor.getName()).getId());
        log.info("收到wor" + wor);
        log.info("收到page" + page);
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Wor> wors = worService.findQuestionOrName(page, rows, wor);
        Integer totals = worService.totalsSelect(wor);
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("wors", wors);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
}
