package com.springboot.management.mapper;

import com.springboot.management.vo.Answer;
import com.springboot.management.vo.Position;
import com.springboot.management.vo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionsMapper {
    List<Question> findAll(Map<Object,Object> map);

    int reply(Answer answer);

    int changeStatus(int status,int id);

    List<Answer> findAnswerByQid(int qid);

    int addQuanity(int qid);

    int banQuestion(Question question);

    int banRows(List list);

    List<Answer> findAllAnswer(Map<Object,Object> map);

    int banAnswer(Answer answer);

    int banAnswerRows(List list);
}
