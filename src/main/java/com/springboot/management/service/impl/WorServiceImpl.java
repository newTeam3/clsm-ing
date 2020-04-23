package com.springboot.management.service.impl;

import com.springboot.management.mapper.WorDao;
import com.springboot.management.service.BankService;
import com.springboot.management.service.WorService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorServiceImpl implements WorService {
    @Autowired
    private WorDao worDao;
    @Autowired
    private BankService bankService;
    @Override
    public void save(Wor wor) {
        worDao.save(wor);
        Bank bank = bankService.findOne(String.valueOf(wor.getBankId()));
        bank.setBankCount(bank.getBankCount()+1);
        bankService.update(bank);

    }

    @Override
    public void delete(String id) {
        Wor wor = worDao.findOne(id);
        Bank bank = bankService.findOne(String.valueOf(wor.getBankId()));
        bank.setBankCount(bank.getBankCount()-1);
        bankService.update(bank);
        worDao.delete(id);
    }

    @Override
    public void update(Wor wor) {
        worDao.update(wor);
    }

    @Override
    public List<Wor> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return worDao.findByPage(start,rows);

    }

    @Override
    public Integer findTotals() {
        return worDao.findTotals();
    }
}
