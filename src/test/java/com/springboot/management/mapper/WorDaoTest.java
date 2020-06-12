package com.springboot.management.mapper;

import com.springboot.management.service.WorService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WorDaoTest {

    @Autowired
    private WorService worService;
    @Test
    void findByPage() {
        List<Wor> byPage = worService.findByPage(1, 5);
        for (Wor wor :byPage){
            System.out.println(wor);
        }

    }

    @Test
    void save() {
        Wor wor = new Wor();
     wor.setQuestions("单选");
     wor.setQuestion("下面有关for循环的描述正确的是（）");
     wor.setAnswer("D");
     wor.setName("java");
     wor.setStatus(1);
       worService.save(wor);
    }
    @Test
    void findOne() {
        Wor one = worService.findOne(1);
        System.out.println(one);
    }
    @Test
    void totalSelect() {
        Wor wor = new Wor();
//            wor.setQuestion("下");
//        wor.setName("java");
        Integer integer = worService.totalsSelect(wor);
        System.out.println(integer);
    }
    @Test
    void worDao() {
        Wor wor = new Wor();
//        wor.setQuestion("下");
        wor.setName("j");
        System.out.println(wor);
        List<Wor> byPage = worService.findQuestionOrName(1,4,wor);
        for (Wor wor1 :byPage){
            System.out.println(wor1);
        }
    }
    @Test
    public void Answer(){
        String paperNum="1,3,4,6,8,12,15";
        String[] c = paperNum.split(",");
        List<Wor> wors = new ArrayList<Wor>();
        for (String ss : c){
            Wor one = worService.findByNumber(Integer.valueOf(ss),1);
            wors.add(one);
        }
          System.out.println(wors);
    }
}
