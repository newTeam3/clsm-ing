package com.springboot.management.service.impl;

import com.springboot.management.mapper.ExamDao;
import com.springboot.management.service.ExamService;
import com.springboot.management.vo.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;
    @Override
    public void save(Exam exam) {
        examDao.save(exam);
    }

    @Override
    public void delete(String id) {
        examDao.delete(id);
    }

    @Override
    public void update(Exam exam) {
        examDao.update(exam);
    }

    @Override
    public List<Exam> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return examDao.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return examDao.findTotals();
    }
}
