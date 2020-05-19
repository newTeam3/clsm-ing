package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.GroupMapper;
import com.springboot.management.service.GroupService;
import com.springboot.management.vo.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        //查询
//        Map<String, Object> map = new HashMap<>();
//        map.put("id",pageVO.getKey().get("id"));
//        map.put("name",pageVO.getKey().get("name"));
        //System.out.println("这是impl"+map);
        List<Groups> list = groupMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addGroup(Groups groups) {
        int i = groupMapper.addGroup(groups);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateGroup(Groups groups) {
        int i = groupMapper.updateGroup(groups);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banGroup(Groups groups) {
        int i = groupMapper.banGroup(groups);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = groupMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
