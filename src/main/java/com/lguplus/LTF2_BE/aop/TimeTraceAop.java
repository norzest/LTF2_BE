package com.lguplus.LTF2_BE.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    private static final Logger logger = LoggerFactory.getLogger(TimeTraceAop.class);

    @Around("execution(* com.lguplus.LTF2_BE.api.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("START: " + joinPoint);
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            logger.info("END: " + joinPoint + " " + timeMs + "ms");
        }
    }
}