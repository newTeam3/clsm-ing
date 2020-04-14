package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.LogMapper;
import com.springboot.management.service.LogService;
import com.springboot.management.vo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public void save(SysLog sysLog) {
        int i = logMapper.save(sysLog);
        if (i==0) {
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void deletById(Integer id) {
        int i = logMapper.deletById(id);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public PageInfo findAllByPage(PageVO pageVO) {
        //分页
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        //查询
        List<SysLog> logList = logMapper.findAllByPage(pageVO);

        PageInfo info = new PageInfo(logList);

        return info;
    }

    @Override
    public void deletByIds(List<Integer> ids) {
        for (Integer id : ids){
            int i = logMapper.deletById(id);
            if (i==0){
                throw new MyException(ExceptionEnum.SERVER_CONGESTION);
            }
        }
    }
}
