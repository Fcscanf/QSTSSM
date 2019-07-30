package com.fcant.spring.ch02.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * LoggerAspect
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 18:45 2019-07-30/0030
 */
public class LoggerAspect {
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        // 运行核心业务类之前的时间
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());
        // 运行核心业务类之后的时间
        long endTime = System.currentTimeMillis();
        // 总运行时间
        long time = endTime - startTime;
        System.out.println("耗费时间：" + time);

        return object;
    }
}
