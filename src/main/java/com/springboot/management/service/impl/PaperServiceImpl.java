package com.springboot.management.service.impl;

import com.springboot.management.mapper.BankDao;
import com.springboot.management.mapper.PaperDao;
import com.springboot.management.service.PaperService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private BankDao bankDao;
    @Override
    public void save(Paper paper) {
        paper.setBankId(bankDao.findByBankName(paper.getName()).getId());
        paperDao.save(paper);
    }

    @Override
    public void delete(String id) {
        paperDao.delete(id);
    }

    @Override
    public void update(Paper paper) {

        paper.setBankId(bankDao.findByBankName(paper.getName()).getId());
        paperDao.update(paper);
    }

    @Override
    public List<Paper> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return paperDao.findByPage(start,rows);
    }

    @Override
    public List<Paper> findTimeOrName(Integer page, Integer rows, Paper paper) {
        int start = (page-1)*rows;
        return paperDao.findTimeOrName(start,rows,paper);
    }

    @Override
    public Integer findTotals() {

        return paperDao.findTotals();
    }

    @Override
    public Paper findByBankId(Integer bankId) {

        return paperDao.findByBankId(bankId);
    }

    @Override
    public Paper findOne(Integer id) {

        return paperDao.findOne(id);
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        paperDao.updateStatus(id,status);
    }

    @Override
    public Integer totalsSelect(Paper paper) {
        return paperDao.totalsSelect(paper);
    }
}
