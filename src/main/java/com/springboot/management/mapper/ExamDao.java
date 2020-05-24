package com.springboot.management.mapper;


import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamDao {
    void save(Exam exam);

    void delete(String id);

    void update(Exam exam);

    Exam findByUIdAndPaperId(Integer uid,Integer paperid);

    List<Exam> findByPage(@Param("start") Integer start, @Param("rows") Integer rows,String username);

    List<Exam> findByNameOrScore(@Param("start") Integer start, @Param("rows") Integer rows, Exam exam);

    Integer findTotals(Integer uid);

    Exam findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Exam exam);



}
