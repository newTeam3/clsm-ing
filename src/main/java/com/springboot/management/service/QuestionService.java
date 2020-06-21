package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Answer;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    PageInfo findAll(PageVO pageVO);

    void reply(Answer answer);

    List<Answer> findAnswerByQid(int qid);

    void banQuestion(Question question);

    void banRows(List list);

    PageInfo findAllAnswer(PageVO pageVO);

    void banAnswer(Answer answer);

    void banAnswerRows(List list);

    Map<String,Object> findQuestionById(int id);

    void addQuestion(Question question);
}
