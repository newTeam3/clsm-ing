package com.springboot.management.mapper;

import com.springboot.management.service.BankService;
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class BankDaoTest {
   @Autowired
    private BankService bankService;
    @Test
    void findByBankName() {
//        Bank java = bankService.findByBankName2("c");
//        System.out.println(java);
    }

    @Test
    void findByPage() {
        Bank bank = new Bank();
//        bank.setBankCount(0);
//        bank.setName("j");
        System.out.println(bank);
        List<Bank> byPage = bankService.findNameOrCount(1,4,bank);
        for (Bank wor :byPage){
            System.out.println(wor);
        }
    }
    @Test
    void totalSelect() {
        Bank bank = new Bank();
//        bank.getBank().setName("j");
//        bank.getBank().setBankCount(0);
//        Integer integer = bankService.totalsSelect(bank.getBank());
//        System.out.println(integer);
    }
}