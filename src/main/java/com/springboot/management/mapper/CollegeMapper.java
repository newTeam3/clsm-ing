package com.springboot.management.mapper;

import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/*
 *@Author 李子湘
 * @date 2020/05/02
 *
 */
@Repository
public interface CollegeMapper {
    List<College> findAll(Map<Object,Object> map);

    int addCollege(College college);

    int updateCollege(College college);

    int banCollege(College college);

    int banRows(List list);
}
