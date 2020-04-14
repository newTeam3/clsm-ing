package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.SysLog;

import java.util.List;

public interface LogService {

    void  save(SysLog sysLog);

    void deletById(Integer id);

    PageInfo findAllByPage(PageVO pageVO);

    void deletByIds(List<Integer> ids);
}
