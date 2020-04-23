package com.springboot.management.service;
import com.springboot.management.vo.Wor;

import java.util.List;

public interface WorService {

    void save(Wor wor);

    void delete(String id);

    void update(Wor wor);

    List<Wor> findByPage(Integer page, Integer rows);

    Integer findTotals();
}
