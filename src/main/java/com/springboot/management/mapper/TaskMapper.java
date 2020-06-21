package com.springboot.management.mapper;

import com.springboot.management.vo.*;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskMapper {
    List<Notice> findAll(Map<Object,Object> map);

    int addNotice(Notice notice);

    int updateNotice(Notice notice);

    int banNotice(Notice notice);

    int banRows(List list);

    List<Task> findAllTask(Map<Object,Object> map);

    int addTask(Task task);

    int updateTask(Task task);

    int banTask(Task task);

    int banTaskRows(List list);

//    List<Message> findCommitData(int id);
    List<UserVO> committed(int id);

    List<UserVO> uncommitted(int id);

    Message checkTask(@Param("uid") int uid,@Param("tid") int tid);

}
