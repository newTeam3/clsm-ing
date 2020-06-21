package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.UserMapper;
import com.springboot.management.service.UserService;
import com.springboot.management.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo findAllUser(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<UserVO> list = userMapper.findAllUser(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public Map<String, Object> getSearchData() {
        List<Classes> list1=userMapper.findAllClasses();
        List<Groups> list2=userMapper.findAllGroups();
        List<College> list3=userMapper.findAllCollege();
        List<Position> list4=userMapper.findAllPosition();
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        map.put("class",list1);
        map.put("group",list2);
        map.put("college",list3);
        map.put("position",list4);
        return map;
    }

    @Override
    public void addUser(UserVO userVO) {
        int i = userMapper.addUser(userVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateUser(UserVO userVO) {
        int i = userMapper.updateUser(userVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banUser(UserVO userVO) {
        int i = userMapper.banUser(userVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banUserRows(List list) {
        int i = userMapper.banUserRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public UserVO checkPhone(Map<String, Object> map) {
        UserVO userVO = userMapper.checkPhone(map);
        return userVO;
    }

    @Override
    public void changePwd(UserVO userVO) {
        int i = userMapper.changePwd(userVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public UserVO findUserByID(int id) {
        UserVO userVO=userMapper.findUserByID(id);
        return userVO;
    }

    @Override
    public void changeUserData(UserVO userVO) {
        int i = userMapper.changeUserData(userVO);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public List<RoleVO> findRolesByUid(int userId) {
        List<RoleVO> list=userMapper.findRolesByUid(userId);
        return list;
    }

    @Override
    public void updateRoles(List list,int uid) {
        for(int j=0;j<list.size();j++){
            int i1=userMapper.updateRoles(list.get(j).toString(),uid);
        }
    }

    @Override
    public int deleteAll(int userId) {
        int i=userMapper.deleteAll(userId);
        return i;
    }

}
