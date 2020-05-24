package com.springboot.management.service.impl;

import com.springboot.management.mapper.BankDao;
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
    private BankDao bankDao;
    @Override
    public void save(Wor wor) {
        Integer id = bankDao.findByBankName(wor.getName()).getId();
        Integer totals = worDao.findTotalsByBankId(id);
        wor.setNumber(totals+1);
        wor.setBankId(id);
        worDao.save(wor);
        Bank bank = bankDao.findOne(wor.getBankId());
        bank.setBankCount(bank.getBankCount()+1);
        bankDao.update(bank);

    }

    @Override
    public void delete(String id) {
        Wor wor = worDao.findOne(Integer.valueOf(id));
        Bank bank = bankDao.findOne(wor.getBankId());
        bank.setBankCount(bank.getBankCount()-1);
        bankDao.update(bank);
        worDao.delete(id);
    }

    @Override
    public void update(Wor wor) {
        wor.setBankId(bankDao.findByBankName(wor.getName()).getId());
        worDao.update(wor);
    }

    @Override
    public List<Wor> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return worDao.findByPage(start,rows);

    }

    @Override
    public List<Wor> findQuestionOrName(Integer page, Integer rows, Wor wor) {
        int start = (page-1)*rows;
        return worDao.findQuestionOrName(start,rows,wor);
    }

    @Override
    public Integer findTotals() {
        return worDao.findTotals();
    }

    @Override
    public Wor findByQuestion(String question) {
        return worDao.findByQuestion(question);
    }

    @Override
    public Wor findOne(Integer id) {

        return worDao.findOne(id);
    }

    @Override
    public Wor findByNumber(Integer number,Integer bankId) {
        return worDao.findByNumber(number,bankId);
    }


    @Override
    public void updateStatus(Integer id, Integer status) {
        worDao.updateStatus(id,status);
    }


    @Override
    public Integer totalsSelect(Wor wor) {
        return worDao.totalsSelect(wor);
    }
}
