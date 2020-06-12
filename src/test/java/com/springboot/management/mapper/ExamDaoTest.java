package com.springboot.management.mapper;

import com.springboot.management.service.ExamService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Exam;
import com.springboot.management.vo.UserVO;
import com.springboot.management.vo.Wor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExamDaoTest {

    @Autowired
    private ExamService examService;
//    @Test
//    void findByPage() {
//        List<Exam> exams = examService.findByPage(1, 4);
//        for (Exam exam:exams){
//            System.out.println(exam);
//        }
//    }
//    @Test
//    void save(){
//        Exam exam = new Exam();
//        exam.setName("java");
//        exam.setUsername("admin");
//        exam.setScore(80);
//        examService.save(exam);
//    }
//    @Test
//    void findByUIdAndPaperId(){
//
//        Exam byUIdAndPaperId = examService.findByUIdAndPaperId(14, 1);
//        System.out.println(byUIdAndPaperId);
//    }
//    @Test
//    void findOne(){
//        Exam byUIdAndPaperId = examService.findOne(1);
//        System.out.println(byUIdAndPaperId);
//    }
//    @Test
//    void status(){
//        examService.updateStatus(1,1);
//  }
//    @Test
//    void findByNameOrScore() {
//        Exam exam = new Exam();
////        exam.setUsername("adm");
////          exam.setScore(95);
//        List<Exam> byPage = examService.findByNameOrScore(1,4,exam);
//        for (Exam wor :byPage){
//            System.out.println(wor);
//        }
//    }
    @Test
    void totalSelect() {
        Exam exam = new Exam();
//        exam.setUsername("adm");
//        exam.setScore(0);
//        System.out.println(exam);
        Integer integer = examService.totalsSelect(exam);
        System.out.println(integer);
    }
}
