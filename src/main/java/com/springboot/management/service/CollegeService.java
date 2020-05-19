package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.College;

import java.util.List;

public interface CollegeService {
    PageInfo findAll(PageVO pageVO);

    void addCollege(College college);

    void updateCollege(College college);

    void banCollege(College college);

    void banRows(List list);
}
