package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.RoleVO;

public interface RoleService {
    PageInfo findAllRoles(PageVO pageVO);

    void addRole(RoleVO roleVO);

    void updateRole(RoleVO roleVO);
}
