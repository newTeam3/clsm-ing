package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.CollegeMapper;
import com.springboot.management.service.CollegeService;
import com.springboot.management.vo.Classes;
import com.springboot.management.vo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        //查询
//        Map<String, Object> map = new HashMap<>();
//        map.put("id",pageVO.getKey().get("id"));
//        map.put("name",pageVO.getKey().get("name"));
        //System.out.println("这是impl"+map);
        List<College> list = collegeMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addCollege(College college) {
        int i = collegeMapper.addCollege(college);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateCollege(College college) {
        int i = collegeMapper.updateCollege(college);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banCollege(College college) {
        int i = collegeMapper.banCollege(college);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = collegeMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
