package com.springboot.management.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.springboot.management.service.SendSms;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendSmsImpl implements SendSms {
    @Override
    public boolean sendSms(String phone, Map<Object, Object> code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "");
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求
        CommonRequest request = new CommonRequest();

        request.setSysMethod(MethodType.POST);//不能改
        request.setSysDomain("dysmsapi.aliyuncs.com");//不能改
        request.setSysVersion("2017-05-25");//不能改
        request.setSysAction("SendSms");
        //自定义参数 (手机号，签名，模板code)
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "真香奶茶");
        request.putQueryParameter("TemplateCode", "SMS_176529606");
        //构建短信验证码
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
