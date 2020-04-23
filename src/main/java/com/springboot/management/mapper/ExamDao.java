package com.springboot.management.mapper;


import com.springboot.management.vo.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamDao {
    void save(Exam exam);

    void delete(String id);

    void update(Exam exam);

    Exam findById(String id);

    List<Exam> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotals();

    Exam findOne(String id);
}
