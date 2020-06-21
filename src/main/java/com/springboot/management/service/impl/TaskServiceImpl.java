package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.TaskMapper;
import com.springboot.management.service.TaskService;
import com.springboot.management.vo.Message;
import com.springboot.management.vo.Notice;
import com.springboot.management.vo.Task;
import com.springboot.management.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Notice> list = taskMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addNotice(Notice notice) {
        int i = taskMapper.addNotice(notice);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateNotice(Notice notice) {
        int i = taskMapper.updateNotice(notice);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banNotice(Notice notice) {
        int i = taskMapper.banNotice(notice);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = taskMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public PageInfo findAllTask(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Task> list = taskMapper.findAllTask(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addTask(Task task) {
        int i = taskMapper.addTask(task);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateTask(Task task) {
        int i = taskMapper.updateTask(task);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banTask(Task task) {
        int i = taskMapper.banTask(task);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banTaskRows(List list) {
        int i = taskMapper.banTaskRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public Map<String,Object> findCommitData(int id) {
        List<UserVO> list1=taskMapper.committed(id);
        List<UserVO> list2=taskMapper.uncommitted(id);
        HashMap<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        map.put("commit",list1);
        map.put("uncommit",list2);
        return map;
    }

    @Override
    public boolean checkTask(int uid, int tid) {
        Message message = taskMapper.checkTask(uid, tid);
        if(message!=null){
            return true;
        }else{
            return false;
        }
    }



}
