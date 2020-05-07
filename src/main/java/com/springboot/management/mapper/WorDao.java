package com.springboot.management.mapper;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorDao {
    void save(Wor wor);

    void delete(String id);

    void update(Wor wor);

    Wor findByQuestion(String question);

    List<Wor> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    List<Wor> findQuestionOrName(@Param("start") Integer start, @Param("rows") Integer rows,Wor wor);

    Integer findTotals();

    Wor findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Wor wor);
}
