package com.springboot.management.mapper;

import com.springboot.management.service.PaperService;
import com.springboot.management.vo.Exam;
import com.springboot.management.vo.Paper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PaperDaoTest {
    @Autowired
    private PaperService paperService;

    @Test
    void findByBankId() {
        Paper bankId = paperService.findByBankId(1);
        System.out.println(bankId);
    }
    @Test
    void findByNameOrScore() {
        Paper paper = new Paper();
//        exam.setUsername("adm");
//          exam.setScore(95);
        List<Paper> byPage = paperService.findTimeOrName(1,4,paper);
        for (Paper wor :byPage){
            System.out.println(wor);
        }
    }
    @Test
    void totalSelect() {
        Paper paper = new Paper();
        paper.setName("c");
        Integer integer = paperService.totalsSelect(paper);
        System.out.println(integer);
    }
}