package com.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class MyLogAspect {

    @Resource
    private HttpServletRequest request;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //定义切点
    @Pointcut("@annotation(com.config.annotation.MyLog) || @within(com.config.annotation.MyLog)")
    public void logPointcut() {

    }

    //环绕通知
    @Around("logPointcut()")
    public void around(ProceedingJoinPoint joinPoint){

        //时间
        String time = sdf.format(new Date());
        //ip
        String host = request.getRemoteHost();
        //方法
        String method = joinPoint.getSignature().getName();
        //参数
        String params = Arrays.toString(joinPoint.getArgs());

        System.out.println(time + " " + host + " " + method + " " + params);



        try {
            joinPoint.proceed();
            //System.out.println("继续执行...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("logPointcut()")
    public void before(){
       // System.out.println("前置通知");
    }


    @After("logPointcut()")
    public void after(){
       // System.out.println("后置通知");

    }
}
