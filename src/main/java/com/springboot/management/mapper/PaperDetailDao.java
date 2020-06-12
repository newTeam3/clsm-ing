package com.springboot.management.mapper;/*
 *@Author lee
 * @date 2020/06/11
 */

import com.springboot.management.vo.PaperDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDetailDao {

    void save(List<PaperDetail> paperDetail);

    void update(List<PaperDetail> paperDetail);

    List<PaperDetail> findAll(@Param("uid") Integer uid, @Param("paperId") Integer paperId);
}
