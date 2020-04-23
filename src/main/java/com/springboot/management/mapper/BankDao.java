package com.springboot.management.mapper;

import com.springboot.management.vo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankDao {

    void save(Bank bank);

    void delete(String id);

    void update(Bank bank);

    Bank findByBankName(String name);

    List<Bank> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotals();

    Bank findOne(String id);
}
