package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class Aspect_V1 {

    @Around("execution(* com.example..*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        ProceedingJoinPoint joinPoint1 = joinPoint;
        log.info("log -> {}", joinPoint.getTarget());
        return joinPoint.proceed();
    }
}
