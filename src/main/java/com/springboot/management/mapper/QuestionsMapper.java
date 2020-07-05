package com.springboot.management.mapper;
/*
 *@Author 王立维
 * @date 2020/05/09
 *
 */
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

    Question findQuestionById(int id);

    int addQuestion(Question question);

    //前台消息中心 查看答疑回复我的
    List<Answer> findRequestionComment(Map<Object,Object> map);
}
