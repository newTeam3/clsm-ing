package com.springboot.management.service;


import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Paper;

import java.util.List;

public interface PaperService {
    void save(Paper paper);

    void delete(String id);

    void update(Paper paper);

    List<Paper> findByPage(Integer page, Integer rows);

    List<Paper> findTimeOrName(Integer page, Integer rows, Paper paper);

    Integer findTotals();

    Paper findByBankId(Integer bankId);

    Paper findByPaperName(String  paperName);

    Paper findOne(Integer id);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Paper paper);


}
