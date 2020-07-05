package com.springboot.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.management.common.enums.ExceptionEnum;
import com.springboot.management.common.exception.MyException;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.mapper.ArticleMapper;
import com.springboot.management.service.ArticleService;
import com.springboot.management.vo.Article;
import com.springboot.management.vo.College;
import com.springboot.management.vo.Comment;
import com.springboot.management.vo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/*
 *@Author 左创源
 * @date 2020/04/18
 *文章service实现层
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        int i = articleMapper.addArticle(article);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public PageInfo findAllSort(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Sort> list = articleMapper.findAllSort(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public void addSort(Sort sort) {
        int i = articleMapper.addSort(sort);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void updateSort(Sort sort) {
        int i = articleMapper.updateSort(sort);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banSort(Sort sort) {
        int i = articleMapper.banSort(sort);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banSortRows(List list) {
        int i = articleMapper.banSortRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public PageInfo findAllArticle(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Article> list = articleMapper.findAllArticle(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public List<Sort> getSort() {
        List<Sort> list=articleMapper.getSort();
        return list;
    }

    @Override
    public void banArticle(Article article) {
        int i = articleMapper.banArticle(article);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void banArticleRows(List list) {
        int i = articleMapper.banArticleRows(list);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public Article getArticle(int id) {
        Article article=articleMapper.getArticle(id);
        if(article!=null){
            articleMapper.addQuantity(id);
        }
        return article;
    }


    @Override
    public List<Comment> getComments(int aid) {
        List<Comment> allComments = articleMapper.getComments(aid);
        if (allComments == null || allComments.size() == 0) {
            return new ArrayList<>();
        }
        List<Comment> comments = new ArrayList<>();
        List<Comment> parents = new ArrayList<>();
        for (Comment comment : allComments) {
            if (comment.getPid()==null) {
                comments.add(comment);
                parents.add(comment);
            } else {
                boolean foundParent=false;
                for (Comment parent : parents) {
                    if (comment.getPid().equals(parent.getId())) {
                        if (parent.getChild() == null) {
                            parent.setChild(new ArrayList<>());
                        }
                        parent.getChild().add(comment);
                        parents.add(comment);
                        foundParent=true;
                        //如果对list迭代过程中同时修改list，会报java.util.ConcurrentModificationException 的异常，所以我们需要break,当然break也可以提高算法效率
                        break;
                    }
                }
                if (!foundParent) {
                    throw new RuntimeException("can not find the parent comment");
                }
            }
        }
        return comments;
    }

    @Override
    public void addComments(Comment comment) {
        int i = articleMapper.addComments(comment);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }

    @Override
    public void addReply(Comment comment) {
        int i = articleMapper.addReply(comment);
        if (i==0){
            throw new MyException(ExceptionEnum.SERVER_CONGESTION);
        }
    }
    //查看文章中回复我的消息
    @Override
    public PageInfo getReply(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Comment> list = articleMapper.getReply(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }

    @Override
    public PageInfo getArticleComment(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getRows());
        List<Comment> list = articleMapper.getArticleComment(pageVO.getKey());
        PageInfo info = new PageInfo(list);
        return info;
    }
}
