package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Groups;
import com.springboot.management.vo.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionService {
    PageInfo findAll(PageVO pageVO);

    void addPosition(Position position);

    void updatePosition(Position position);

    void banPosition(Position position);

    void banRows(List list);
}
