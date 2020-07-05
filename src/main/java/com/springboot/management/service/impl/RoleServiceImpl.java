package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.RoleMapper;
import com.springboot.management.service.RoleService;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public PageInfo findAllRoles(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<RoleVO> list = roleMapper.findAllRoles(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addRole(RoleVO roleVO) {
        int i = roleMapper.addRole(roleVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateRole(RoleVO roleVO) {
        int i = roleMapper.updateRole(roleVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
