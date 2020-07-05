package com.springboot.management.mapper;

import com.springboot.management.vo.Classes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/*
 *@Author 杨伟棋
 * @date 2020/04/28
 *
 */
@Repository
public interface EchartsMapper {
    List<Map<String,Object>> getClasses();

    List<Map<String,Object>> getSex();
}
