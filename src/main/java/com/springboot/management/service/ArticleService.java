package com.springboot.management.service;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.vo.Article;
import com.springboot.management.vo.College;
import com.springboot.management.vo.Comment;
import com.springboot.management.vo.Sort;

import java.util.List;

public interface ArticleService {
    void addArticle(Article article);

    PageInfo findAllSort(PageVO pageVO);

    void addSort(Sort sort);

    void updateSort(Sort sort);

    void banSort(Sort sort);

    void banSortRows(List list);

    PageInfo findAllArticle(PageVO pageVO);

    List<Sort> getSort();

    void banArticle(Article article);

    void banArticleRows(List list);

    Article getArticle(int id);

    List<Comment> getComments(int aid);

    void addComments(Comment comment);

    void addReply(Comment comment);

    PageInfo getReply(PageVO pageVO);

    PageInfo getArticleComment(PageVO pageVO);

}
