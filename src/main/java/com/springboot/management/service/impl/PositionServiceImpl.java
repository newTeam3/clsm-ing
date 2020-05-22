package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.PositionMapper;
import com.springboot.management.service.PositionService;
import com.springboot.management.vo.Groups;
import com.springboot.management.vo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Position> list = positionMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addPosition(Position position) {
        int i = positionMapper.addPosition(position);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updatePosition(Position position) {
        int i = positionMapper.updatePosition(position);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banPosition(Position position) {
        int i = positionMapper.banPosition(position);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = positionMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
