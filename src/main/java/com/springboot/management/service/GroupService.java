package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Groups;

import java.util.List;

public interface GroupService {
    PageInfo findAll(PageVO pageVO);

    void addGroup(Groups group);

    void updateGroup(Groups group);

    void banGroup(Groups group);

    void banRows(List list);
}
