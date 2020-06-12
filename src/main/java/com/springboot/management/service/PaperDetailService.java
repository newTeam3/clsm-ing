package com.springboot.management.service;/*
 *@Author lee
 * @date 2020/06/11
 */

import com.springboot.management.vo.PaperDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDetailService {
    void save(@Param("paperDetail") List<PaperDetail> paperDetail);

    void update(@Param("paperDetail") List<PaperDetail> paperDetail);

    List<PaperDetail> findAll(Integer uid,Integer bankId);
}
