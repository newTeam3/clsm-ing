package com.springboot.management.service;

import com.springboot.management.vo.Bank;

import java.util.List;

public interface BankService  {

    void save(Bank bank);

    void delete(String id);

    void update(Bank bank);

    List<Bank> findByPage(Integer page, Integer rows);

    Integer findTotals();

    Bank findOne(String id);



}
