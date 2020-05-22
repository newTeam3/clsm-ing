package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Answer;
import com.springboot.management.vo.Evaluate;
import com.springboot.management.vo.Message;
import com.springboot.management.vo.Task;


import java.util.List;

public interface MessageService {
    PageInfo findAll(PageVO pageVO);

    List<Evaluate> findEvaluateByMid(int mid);

    void banMessage(Message message);

    void banMessageRows(List list);

    void evaluate(Evaluate evaluate);

    List<Task> getContentAll(int sort);

    PageInfo findAllWeekReport(PageVO pageVO);

    void commit(Message message);
}
