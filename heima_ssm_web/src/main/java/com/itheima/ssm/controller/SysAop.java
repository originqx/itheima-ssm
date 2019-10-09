package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: QX
 * @Date: 2019/10/8 12:58
 * @Version 1.0
 */
@Component
@Aspect
public class SysAop {
    private Date startTime;
    private Class clazz;
    private Method method;
    private String url;
    @Autowired
    HttpServletRequest request;
    @Autowired
    SysLogService logService;
    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();
        clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        }else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classes);
        }
    }


    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){

        Long executionTime = new Date().getTime() - startTime.getTime();
        if (clazz != null && method != null && clazz != SysAop.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String[] className = classAnnotation.value();
            if (method != null) {
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodName = methodAnnotation.value();
                    url = className[0] + methodName[0];
                }
            }
        }
        String ipAdress = request.getRemoteAddr();
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String userName = user.getUsername();
        SysLog log = new SysLog();
        log.setExecutionTime(executionTime);
        log.setIp(ipAdress);
        log.setMethod("类名：" + clazz.getName() + "方法名："+method.getName());
        log.setUrl(url);
        log.setUsername(userName);
        log.setVisitTime(startTime);
        logService.save(log);
    }
}
