package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.ClassesMapper;
import com.springboot.management.service.ClassesService;
import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *@Author 李子湘
 * @date 2020/05/02
 *
 */
@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    ClassesMapper classesMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        //查询
//        Map<String, Object> map = new HashMap<>();
//        map.put("id",pageVO.getKey().get("id"));
//        map.put("name",pageVO.getKey().get("name"));
        //System.out.println("这是impl"+map);
        List<Classes> list = classesMapper.findAll(pageVO.getKey());
//        System.out.println("这是service里的"+list);
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public List<College> findAllCollege() {
        return classesMapper.findAllCollege();
    }

    @Override
    public void addClasses(Classes classes) {
        int i = classesMapper.addClasses(classes);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }

    }

    @Override
    public void updateClasses(Classes classes) {
        int i = classesMapper.updateClasses(classes);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banClasses(Classes classes) {
        int i = classesMapper.banClasses(classes);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = classesMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
