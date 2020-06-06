package com.springboot.management.mapper;

import com.springboot.management.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface ArticleMapper {
    int addArticle(Article article);

    List<Sort> findAllSort(Map<Object,Object> map);

    int addSort(Sort sort);

    int updateSort(Sort sort);

    int banSort(Sort sort);

    int banSortRows(List list);

    List<Article> findAllArticle(Map<Object,Object> map);

    List<Sort> getSort();

    int banArticle(Article article);

    int banArticleRows(List list);

    Article getArticle(int id);

    int addQuantity(int id);

    //查询所有评论
    List<Comment> getComments(Integer aid);

    int addComments(Comment comment);

    int addReply(Comment comment);

}
