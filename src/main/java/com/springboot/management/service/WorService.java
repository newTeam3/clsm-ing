package com.springboot.management.service;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;

import java.util.List;

public interface WorService {

    void save(Wor wor);

    void delete(String id);

    void update(Wor wor);

    List<Wor> findByPage(Integer page, Integer rows);

    Integer findTotals();

    Wor findByQuestion(String question);

    Wor findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    List<Wor> findQuestionOrName(Integer page, Integer rows,Wor wor);

    Integer totalsSelect(Wor wor);

}
