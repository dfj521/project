package com.dfj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    用于记录日志的方面组件，展示Spring AOP的各种通知类型
    SpringAOP相关注解及含义如下：
    @Aspect: 用于声明方面组件
    @Before: 用于声明前置通知
    @AfterReturning: 用于声明后置通知
    @After: 用于声明最终通知
    @Around: 用于声明环绕通知
    @AfterThrowing: 用于声明异常通知
 */
@Component
@Aspect
public class OperateLogger {
    private int num;
    /*
        前置通知，后置通知，最终通知使用的方法
     */
    @Before("within(com.dfj.controller..*)")
    public void before() {
        //记录日志
        System.out.println("---->前置通知记录用户操作日志" + ++num);
    }

    @AfterReturning("within(com.dfj.controller..*)")
    public void afterReturning() {
        System.out.println("---->后置通知记录用户操作日志" + ++num);
    }

    @After("within(com.dfj.controller..*)")
    public void after() {
        System.out.println("---->最终通知记录用户操作日志" + ++num);
    }

    /*环绕通知使用的方法*/
    @Around("within(com.dfj.controller..*)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取目标组件的类名
        String className = pjp.getTarget().getClass().getName();
        //获取目标组件调用的方法名
        String methodName = pjp.getSignature().getName();
        //获取当前时间
        String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        //拼日志信息
        String msg = "--->用户在" + currentTime + ",访问了" + className + "类,并执行了" + methodName + "方法。";
        //记录日志
        System.out.println(msg);
        //执行目标组件的方法
        Object proceed = pjp.proceed();
        //在调用目标组件业务方法后也可以做一些业务处理
        System.out.println("--->调用目标组件业务方法后...");
        return proceed;
    }
    /*异常通知*/
    @AfterThrowing(pointcut = "within(com.dfj.controller..*)", throwing = "e")
    public void afterThrowing(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        //将异常信息进行打印
        System.out.println("--->异常通知" + stackTrace[0].toString());
    }
}
