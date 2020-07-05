package com.springboot.management.mapper;

import com.springboot.management.vo.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/*
 *@Author 李恒彪
 * @date 2020/04/16
 *
 */
public interface BankDao {

    void save(Bank bank);

    void delete(String id);

    void update(Bank bank);

    Bank findByBankName(String name);

    Bank findByBankName2(String name);

    List<Bank> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    List<Bank> findNameOrCount(@Param("start") Integer start, @Param("rows") Integer rows,Bank bank);

    Integer findTotals();

    Bank findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Bank bank);

}
