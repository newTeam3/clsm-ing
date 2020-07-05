package com.springboot.management.service.impl;

import com.springboot.management.mapper.EchartsMapper;
import com.springboot.management.service.EchartsService;
import com.springboot.management.vo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/*
 *@Author 杨伟棋
 * @date 2020/05/05
 *
 */
@Service
@Transactional
public class EchartsServiceImpl implements EchartsService {
    @Autowired
    EchartsMapper echartsMapper;
    @Override
    public List<Map<String,Object>> getClasses() {
        List<Map<String,Object>> list= echartsMapper.getClasses();
        return list;
    }

    @Override
    public List<Map<String, Object>> getSex() {
        List<Map<String,Object>> list= echartsMapper.getSex();
        return list;
    }
}
