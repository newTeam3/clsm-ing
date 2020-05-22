package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Message;
import com.springboot.management.vo.Notice;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskService {
    PageInfo findAll(PageVO pageVO);

    void addNotice(Notice notice);

    void updateNotice(Notice notice);

    void banNotice(Notice notice);

    void banRows(List list);

    PageInfo findAllTask(PageVO pageVO);

    void addTask(Task task);

    void updateTask(Task task);

    void banTask(Task task);

    void banTaskRows(List list);

    Map<String,Object> findCommitData(int id);

    boolean checkTask(int uid,int tid);
}
