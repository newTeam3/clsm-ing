package com.springboot.management.mapper;

import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
    List<College> findAll(Map<Object,Object> map);

    int addCollege(College college);

    int updateCollege(College college);

    int banCollege(College college);

    int banRows(List list);
}
