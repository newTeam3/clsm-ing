package com.springboot.management.service.impl;

import com.springboot.management.mapper.*;
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
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(Exam exam) {

        exam.setPaperid(paperDao.findByPaperName(exam.getPaperName()).getId());
        exam.setUid(userMapper.getUserByName(exam.getUsername()).getId());
        examDao.save(exam);
    }

    @Override
    public void delete(String id) {
        examDao.delete(id);
    }

    @Override
    public void update(Exam exam) {
        exam.setPaperid(paperDao.findByPaperName(exam.getPaperName()).getId());
        exam.setUid(userMapper.getUserByName(exam.getUsername()).getId());
        examDao.update(exam);
    }

    @Override
    public List<Exam> findByPage(Integer page, Integer rows,String username) {
        int start = (page-1)*rows;
        return examDao.findByPage(start,rows,username);
    }

    @Override
    public List<Exam> findByNameOrScore(Integer page, Integer rows, Exam exam) {
        int start = (page-1)*rows;
        return examDao.findByNameOrScore(start,rows,exam);
    }

    @Override
    public Integer findTotals(Integer uid) {

        return examDao.findTotals(uid);
    }

    @Override
    public Exam findByUIdAndPaperId(Integer uid, Integer paperid) {
        return examDao.findByUIdAndPaperId(uid,paperid);
    }

    @Override
    public Exam findOne(Integer id) {
        return examDao.findOne(id);
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        examDao.updateStatus(id,status);
    }

    @Override
    public Integer totalsSelect(Exam exam) {

            return examDao.totalsSelect(exam);
        }


}
