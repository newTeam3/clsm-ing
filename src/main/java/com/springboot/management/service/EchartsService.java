package com.springboot.management.service;

import com.springboot.management.vo.Classes;

import java.util.List;
import java.util.Map;

public interface EchartsService {
    List<Map<String,Object>> getClasses();

    List<Map<String,Object>> getSex();

}
