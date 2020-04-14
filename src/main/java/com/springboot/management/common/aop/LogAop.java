package com.springboot.management.common.aop;

import com.springboot.management.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

//@Component
//@Aspect
public class LogAop {
    /**
    @Autowired
    private LogService logService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    //前置通知 获取开始时间 执行的类 执行的方法
    @Before("execution(* com.springboot.management.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                    classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classes);
        }
    }

    //后置通知
    @After("execution(* com.springboot.management.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        int time = (int) (new Date().getTime() - visitTime.getTime());
        String url = "";
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取url
        if (clazz != null && method != null) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] value = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] value1 = methodAnnotation.value();
                    url = value[0] + value1[0];

                    //获取ip
                    String ip = request.getRemoteAddr();
                    //获取用户
                    UserVO userVO = (UserVO) SecurityUtils.getSubject().getPrincipal();

                    if(!StringUtils.isEmpty(userVO)) {
                        String userName = userVO.getUsername();

                        SysLog sysLog = new SysLog();
                        sysLog.setExecutionTime(time);
                        sysLog.setIp(ip);
                        sysLog.setMethod("类名" + clazz.getName() + "方法名" + method.getName());
                        sysLog.setUrl(url);
                        sysLog.setUsername(userName);
                        sysLog.setVisitTime(visitTime);

                        logService.save(sysLog);
                    }
                }
            }
        }
    }
    **/
}
