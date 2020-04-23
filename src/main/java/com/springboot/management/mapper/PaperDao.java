package com.springboot.management.mapper;

import com.springboot.management.vo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDao {
    void save(Paper paper);

    void delete(String id);

    void update(Paper paper);

    List<Paper> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotals();

    Paper findOne(String id);
}
