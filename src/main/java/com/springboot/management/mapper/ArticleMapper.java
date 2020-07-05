package com.springboot.management.mapper;

import com.springboot.management.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/*
 *@Author 左创源
 * @date 2020/04/22
 *文章模块daoc层接口
 */

public interface ArticleMapper {
    //添加文章
    int addArticle(Article article);
    //查询所有文章
    List<Sort> findAllSort(Map<Object,Object> map);
    //添加文章分类
    int addSort(Sort sort);
    //修改文章信息
    int updateSort(Sort sort);
    //禁用单个文章分类
    int banSort(Sort sort);
    //批量禁用文章分类
    int banSortRows(List list);
    //查询所有文章信息
    List<Article> findAllArticle(Map<Object,Object> map);
    //获取下拉菜单中的分类
    List<Sort> getSort();
    //禁用单篇文章
    int banArticle(Article article);
    //批量禁用文章
    int banArticleRows(List list);
    //通过文章id查询详情
    Article getArticle(int id);
    //每次点击浏览，文章阅读量加一
    int addQuantity(int id);

    //查询所有评论
    List<Comment> getComments(Integer aid);
    //添加一个评论
    int addComments(Comment comment);
    //回复评论
    int addReply(Comment comment);
    //查询所有评论回复
    List<Comment> getReply(Map<Object,Object> map);
    //查询单篇文章的所有评论回复
    List<Comment> getArticleComment(Map<Object,Object> map);
}
