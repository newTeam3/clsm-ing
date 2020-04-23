package com.springboot.management.service;

import com.springboot.management.vo.Exam;

import java.util.List;

public interface ExamService {
    void save(Exam exam);

    void delete(String id);

    void update(Exam exam);

    List<Exam> findByPage(Integer page, Integer rows);

    Integer findTotals();
}
