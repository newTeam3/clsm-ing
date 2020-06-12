package com.springboot.management.mapper;

import com.springboot.management.config.Dasdas;
import com.springboot.management.service.PaperService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Exam;
import com.springboot.management.vo.Paper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
    @Test
    public void save(){
        Paper paper = new Paper();
        paper.setName("c语言");
        paper.setTime("60");
        paper.setPaperName("c语言测试2");
        paper.setTotalScore(100);
        paperService.save(paper);
    }
    @Autowired
    private BankDao bankDao;
    @Autowired
    private Dasdas dasdas;
    @Test
  public void sssss(){
//       System.out.println( dasdas.random());
    }

}
