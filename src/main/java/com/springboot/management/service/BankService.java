package com.springboot.management.service;

import com.springboot.management.vo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankService  {

    void save(Bank bank);

    void delete(String id);

    void update(Bank bank);

    List<Bank> findByPage(Integer page, Integer rows);

    Integer findTotals();

    Bank findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Bank findByBankName(String name);

    Bank findByBankName2(String name);

    List<Bank> findNameOrCount(Integer page, Integer rows,Bank bank);

    Integer totalsSelect(Bank bank);



}
