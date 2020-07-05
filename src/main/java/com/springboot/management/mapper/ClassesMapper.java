package com.springboot.management.mapper;

import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/*
 *@Author 李子湘
 * @date 2020/05/03
 *
 */
@Repository
public interface ClassesMapper {
//   mapper映射文件路径 resources/mybatis/classessMapper.xml
    List<Classes> findAll(Map<Object,Object> map);

    List<College> findAllCollege();

    int addClasses(Classes classes);

    int updateClasses(Classes classes);

    int banClasses(Classes classes);

    int banRows(List list);
}
