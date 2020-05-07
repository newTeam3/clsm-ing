package com.springboot.management.mapper;

import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Exam;
import com.springboot.management.vo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDao {
    void save(Paper paper);

    void delete(String id);

    void update(Paper paper);

    List<Paper> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    List<Paper> findTimeOrName(@Param("start") Integer start, @Param("rows") Integer rows, Paper paper);

    Integer findTotals();

    Paper findOne(Integer id);

    Paper findByBankId(Integer bankId);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Paper paper);
}
