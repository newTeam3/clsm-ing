package com.springboot.management.config;


import org.springframework.stereotype.Component;

import java.util.HashSet;

import java.util.Random;
@Component
public class Dasdas {

    public String random(Integer num){
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        HashSet<Integer> hs = new HashSet<Integer>();
        while(hs.size() < 10){
            hs.add(random.nextInt(num)+1);
        }
        for (Integer integer : hs) {
//            System.out.println(integer);
            result = result.append(integer);
            result.append(",");
        }
       return (result.substring(0, result.length()-1));
    }
}
