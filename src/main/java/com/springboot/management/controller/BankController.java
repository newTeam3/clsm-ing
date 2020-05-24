package com.springboot.management.controller;

import com.springboot.management.service.BankService;
import com.springboot.management.vo.Bank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bank")
@Slf4j
public class BankController {

    @Autowired
    private BankService bankService;

    //查询所有
    @GetMapping("/findAllBank")
    public Map<String, Object> findBuPage(Integer page, Integer rows) {
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Bank> banks = bankService.findByPage(page, rows);
        Integer totals = bankService.findTotals();
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("banks", banks);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
    @PostMapping("/save")
    public String save(@RequestBody Bank bank) {
//       log.info("收到的" + bank);
        Bank bankName = bankService.findByBankName(bank.getName());
        if (bankName==null){
            try {
                bankService.save(bank);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail";
            }
        }else {
            return "repeat";
        }
    }
    //删除
    @GetMapping("/delete")
    public String delete(String id) {
        log.info("收到的id" + id);
        try {
            bankService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @GetMapping("/findOne")
    public Bank findOne(Integer id) {
        return bankService.findOne(id);
    }

    //修改
    @PostMapping("/update")
    public String update(@RequestBody Bank bank) {


        try {
            bankService.update(bank);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping("/updateStatus")
    public String updateStatus(Integer id,Integer status) {
        try {
            bankService.updateStatus(id,status);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //根据关键字
    @PostMapping("/findNameOrCount")
    public Map<String, Object> findNameOrCount(@RequestParam(value = "page",required = false ,defaultValue = "1") Integer page, @RequestParam(value = "size",required = false ,defaultValue = "4") Integer rows, @RequestBody Bank bank) {
        log.info("收到的bank" + bank);
        log.info("page" + page);
        page = page == null ? 1 : page;
        rows = rows == null ? 4 : rows;
        HashMap<String, Object> map = new HashMap<>();
        //分页处理
        List<Bank> banks = bankService.findNameOrCount(page,rows,bank);
        Integer totals = bankService.totalsSelect(bank);
        log.info("多少页"+totals);
        Integer totalPage = totals % rows == 0 ? totals / rows : totals / rows + 1;
        map.put("banks", banks);
        map.put("totals", totals);
        map.put("totalPage", totalPage);
        map.put("page", page);
        return map;
    }
}
