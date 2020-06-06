package com.springboot.management.service;

import java.util.Map;

public interface SendSms {
    public boolean sendSms(String phone, Map<Object, Object> code);
}
