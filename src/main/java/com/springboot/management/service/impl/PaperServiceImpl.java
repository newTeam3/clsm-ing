package com.springboot.management.service.impl;

import com.springboot.management.mapper.PaperDao;
import com.springboot.management.service.PaperService;
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
    @Override
    public void save(Paper paper) {
        paperDao.save(paper);
    }

    @Override
    public void delete(String id) {
        paperDao.delete(id);
    }

    @Override
    public void update(Paper paper) {
        paperDao.update(paper);
    }

    @Override
    public List<Paper> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return paperDao.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return paperDao.findTotals();
    }
}
