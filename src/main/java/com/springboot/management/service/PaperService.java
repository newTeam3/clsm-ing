package com.springboot.management.service;


import com.springboot.management.vo.Paper;

import java.util.List;

public interface PaperService {
    void save(Paper paper);

    void delete(String id);

    void update(Paper paper);

    List<Paper> findByPage(Integer page, Integer rows);

    Integer findTotals();
}
