package com.springboot.management.mapper;

import com.springboot.management.vo.Groups;
import com.springboot.management.vo.Position;

import java.util.List;
import java.util.Map;
/*
 *@Author 聂精威
 * @date 2020/05/04
 *
 */
public interface PositionMapper {
    List<Position> findAll(Map<Object,Object> map);

    int addPosition(Position position);

    int updatePosition(Position position);

    int banPosition(Position position);

    int banRows(List list);
}
