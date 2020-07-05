package com.springboot.management.mapper;

import com.springboot.management.vo.Groups;

import java.util.List;
import java.util.Map;
/*
 *@Author 聂精威
 * @date 2020/05/04
 *
 */
public interface GroupMapper {
    List<Groups> findAll(Map<Object,Object> map);

    int addGroup(Groups groups);

    int updateGroup(Groups groups);

    int banGroup(Groups groups);

    int banRows(List list);
}
