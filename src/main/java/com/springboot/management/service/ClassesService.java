package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;

import java.util.List;

public interface ClassesService {
    PageInfo findAll(PageVO pageVO);

    List<College> findAllCollege();

    void addClasses(Classes classes);

    void updateClasses(Classes classes);

    void banClasses(Classes classes);

    void banRows(List list);
}
