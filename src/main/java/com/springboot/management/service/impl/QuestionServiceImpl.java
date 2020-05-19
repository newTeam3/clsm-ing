package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.QuestionsMapper;
import com.springboot.management.service.QuestionService;
import com.springboot.management.vo.Answer;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionsMapper questionsMapper;

    @Override
    public PageInfo findAll(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Question> list = questionsMapper.findAll(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void reply(Answer answer) {
        int i = questionsMapper.reply(answer);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }else{
            questionsMapper.changeStatus(1,answer.getQuestion().getId());
        }
    }

    @Override
    public List<Answer> findAnswerByQid(int qid) {
        List<Answer> list = questionsMapper.findAnswerByQid(qid);
        questionsMapper.addQuanity(qid);
        return list;
    }

    @Override
    public void banQuestion(Question question) {
        int i = questionsMapper.banQuestion(question);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banRows(List list) {
        int i = questionsMapper.banRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public PageInfo findAllAnswer(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Answer> list = questionsMapper.findAllAnswer(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void banAnswer(Answer answer) {
        int i = questionsMapper.banAnswer(answer);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banAnswerRows(List list) {
        int i = questionsMapper.banAnswerRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
}
