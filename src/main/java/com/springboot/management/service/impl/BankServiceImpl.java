package com.springboot.management.service.impl;

import com.springboot.management.mapper.BankDao;
import com.springboot.management.service.BankService;
import com.springboot.management.vo.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {
    @Autowired
    private BankDao bankDao;

    @Override
    public void save(Bank bank) {
        bankDao.save(bank);
    }

    @Override
    public void delete(String id) {
        bankDao.delete(id);
    }

    @Override
    public void update(Bank bank) {
        bankDao.update(bank);
    }


    @Override
    public List<Bank> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return bankDao.findByPage(start,rows);

    }

    @Override
    public Integer findTotals() {

        return bankDao.findTotals();
    }

    @Override
    public Bank findOne(String id) {

        return bankDao.findOne(id);
    }
}
