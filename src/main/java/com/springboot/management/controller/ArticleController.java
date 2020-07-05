package com.springboot.management.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.management.common.utils.PageVO;
import com.springboot.management.service.ArticleService;
import com.springboot.management.vo.Article;
import com.springboot.management.vo.College;
import com.springboot.management.vo.Comment;
import com.springboot.management.vo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
/*
 * 左创源
 * 5.12
 *文章管理的控制类
 * */

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    //新增文章
    @PostMapping(value = "/addArticle")
    public ResponseEntity<?> addArticle(@RequestBody Article article) {
        Date date = new Date();
        //将date类型转换为timestamp类型
        Timestamp timestamp = new Timestamp(date.getTime());
        article.setCreateTime(timestamp);
        articleService.addArticle(article);
        return ResponseEntity.ok("操作成功");
    }
    //查找所有的文章类别
    @PostMapping(value = "/findAllSort")
    public ResponseEntity<?> findAllSort(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = articleService.findAllSort(pageVO);
        return ResponseEntity.ok(pageInfo);
    }

    //添加文章类别
    @PostMapping(value = "/addSort")
    public ResponseEntity<?> addSort(@RequestBody Sort sort) {
        articleService.addSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //修改文章类别
    @PostMapping(value = "/updateSort")
    public ResponseEntity<?> updateSort(@RequestBody Sort sort) {
        articleService.updateSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //单个文章类别的启用及禁用
    @PostMapping(value = "/banSort")
    public ResponseEntity<?> banSort(@RequestBody Sort sort) {
        articleService.banSort(sort);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用文章分类
    @GetMapping(value = "/banSortRows")
    public ResponseEntity<?> banSortRows(@RequestParam("ids") String ids) {
        //将字符串以逗号分割，存入list中
        List<String> list = Arrays.asList(ids.split(","));
        articleService.banSortRows(list);
        return ResponseEntity.ok("操作成功");
    }
    //查找所有的文章
    @PostMapping(value = "/findAllArticle")
    public ResponseEntity<?> findAllArticle(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = articleService.findAllArticle(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //用于下拉菜单中动态渲染文章分类
    @GetMapping(value = "/getSort")
    public ResponseEntity<?> getSort() {
        List<Sort> list = articleService.getSort();
        return ResponseEntity.ok(list);
    }
    //禁用文章
    @PostMapping(value = "/banArticle")
    public ResponseEntity<?> banArticle(@RequestBody Article article) {
        articleService.banArticle(article);
        return ResponseEntity.ok("操作成功");
    }
    //批量禁用文章
    @GetMapping(value = "/banArticleRows")
    public ResponseEntity<?> banArticleRows(@RequestParam("ids") String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        articleService.banArticleRows(list);
        return ResponseEntity.ok("操作成功");
    }
    //根据id查询具体的文章详情
    @GetMapping(value = "/getArticle")
    public ResponseEntity<?> getArticle(@RequestParam("id") int id) {
        Article article = articleService.getArticle(id);
        return ResponseEntity.ok(article);
    }
    //根据文章id查询所有评论和回复
    @GetMapping(value = "/getComments")
    public ResponseEntity<?> getComments(@RequestParam("aid") int aid) {
        List<Comment> list = articleService.getComments(aid);
        return ResponseEntity.ok(list);
    }
    //发表评论
    @PostMapping(value = "/addComments")
    public ResponseEntity<?> addComments(@RequestBody Comment comment) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime(timestamp);
        articleService.addComments(comment);
        return ResponseEntity.ok("操作成功");
    }
    //发表评论或回复
    @PostMapping(value = "/addReply")
    public ResponseEntity<?> addReply(@RequestBody Comment comment) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        comment.setTime(timestamp);
        articleService.addReply(comment);
        return ResponseEntity.ok("操作成功");
    }
    //查看文章中回复我的消息
    @PostMapping(value = "/getReply")
    public ResponseEntity<?> getReply(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = articleService.getReply(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
    //查看文章我的文章的评价
    @PostMapping(value = "/getArticleComment")
    public ResponseEntity<?> getArticleComment(@RequestBody PageVO pageVO) {
        PageInfo pageInfo = articleService.getArticleComment(pageVO);
        return ResponseEntity.ok(pageInfo);
    }
}
