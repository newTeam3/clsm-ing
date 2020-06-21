package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.MessageMapper;
import com.springboot.management.service.MessageService;
import com.springboot.management.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        System.out.println("这是impl"+pageVO.getKey());
        List<Message> list = messageMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public List<Evaluate> findEvaluateByMid(int mid) {
        List<Evaluate> list = messageMapper.findEvaluateByMid(mid);
        return list;
    }

    @Override
    public void banMessage(Message message) {
        int i = messageMapper.banMessage(message);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banMessageRows(List list) {
        int i = messageMapper.banMessageRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }


    @Override
    public void evaluate(Evaluate evaluate) {
        int i = messageMapper.evaluate(evaluate);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }else{
            messageMapper.changeState(1,evaluate.getMessage().getId());
        }
    }

    @Override
    public List<Task> getContentAll(int sort) {
        List<Task> list=messageMapper.getContentAll(sort);
        return list;
    }

    @Override
    public PageInfo findAllWeekReport(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        System.out.println("这是impl"+pageVO.getKey());
        List<Message> list = messageMapper.findAllWeekReport(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void commit(Message message) {
        int i = messageMapper.commit(message);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }else{
            messageMapper.addCount(message.getTask().getId());
        }

    }

    @Override
    public Message getMessageItem(int id) {
        Message message=messageMapper.getMessageItem(id);
        return message;
    }

    @Override
    public PageInfo getMessageByUid(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Message> list = messageMapper.getMessageByUid(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

}
