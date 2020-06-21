package com.springboot.management.mapper;

import com.springboot.management.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface MessageMapper {
    List<Message> findAll(Map<Object,Object> map);

    int evaluate(Evaluate evaluate);

    int changeState(int state,int id);

    List<Evaluate> findEvaluateByMid(int mid);

    int banMessage(Message message);

    int banMessageRows(List list);

    List<Task> getContentAll(int sort);

    List<Message> findAllWeekReport(Map<Object,Object> map);

    int commit(Message message);

    int addCount(int id);

    Message getMessageItem(int id);

    List<Message> getMessageByUid(Map<Object,Object> map);
}
