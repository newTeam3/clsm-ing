package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.RoleVO;
import com.springboot.management.vo.Task;
import com.springboot.management.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService {
    PageInfo findAllUser(PageVO pageVO);

    Map<String,Object> getSearchData();

    void addUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void banUser(UserVO userVO);

    void banUserRows(List list);

    UserVO checkPhone(Map<String,Object> map);

    void changePwd(UserVO userVO);

    UserVO findUserByID(int id);

    void changeUserData(UserVO userVO);

    List<RoleVO> findRolesByUid(int userId);

    void updateRoles(List list,int uid);

    int  deleteAll(int userId);
}
