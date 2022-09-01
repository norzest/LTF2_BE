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

    // 콘솔에 정보를 출력하기 위한 logger 설정
    private static final Logger logger = LoggerFactory.getLogger(TimeTraceAop.class);

    @Around("execution(* com.lguplus.LTF2_BE.api.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        // 해당 클래스의 실행 확인 출력
        logger.info("START: " + joinPoint);
        try {
            // aop가 적용된 메소드를 전체 수행하고 리턴되는 데이터를 받는다
            // 정상 작동 여부는 상관 X
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            // 해당 클래스의 종료 확인 및 실행 시간 출력
            logger.info("END: " + joinPoint + " " + timeMs + "ms");
        }
    }
}