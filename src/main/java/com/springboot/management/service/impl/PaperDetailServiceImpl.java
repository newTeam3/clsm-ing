package com.springboot.management.service.impl;/*
 *@Author lee
 * @date 2020/06/11
 */

import com.springboot.management.mapper.PaperDetailDao;
import com.springboot.management.service.PaperDetailService;
import com.springboot.management.vo.PaperDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaperDetailServiceImpl implements PaperDetailService {

    @Autowired
    private PaperDetailDao paperDetailDao;

    @Override
    public void save(List<PaperDetail> paperDetail) {
        paperDetailDao.save(paperDetail);
    }

    @Override
    public void update(List<PaperDetail> paperDetail) {
        paperDetailDao.update(paperDetail);
    }

    @Override
    public List<PaperDetail> findAll(Integer uid, Integer paperId) {

        return paperDetailDao.findAll(uid,paperId);
    }
}
