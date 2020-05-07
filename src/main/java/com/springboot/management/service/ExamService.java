package com.springboot.management.service;

import com.springboot.management.vo.Exam;

import java.util.List;

public interface ExamService {
    void save(Exam exam);

    void delete(String id);

    void update(Exam exam);

    List<Exam> findByPage(Integer page, Integer rows);

    List<Exam> findByNameOrScore(Integer page, Integer rows,Exam exam);

    Integer findTotals();

    Exam findByUIdAndPaperId(Integer uid,Integer paperid);

    Exam findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Exam exam);
}
