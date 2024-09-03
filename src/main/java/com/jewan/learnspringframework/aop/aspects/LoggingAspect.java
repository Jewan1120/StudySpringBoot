package com.jewan.learnspringframework.aop.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // Aspect 정의
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut -> When ?
    // 어떤 메서드를 인터셉트할 건지.
    // execution(* PACKAGE.*.*(..))
    // @Pointcut("execution(* com.jewan.learnspringframework.aop.business.*.*(..)")
    @Before("execution(* com.jewan.learnspringframework.aop.*.*.*(..))")
    public void logMethodCallBeforeExecution(Joinpoint joinpoint) {
        // Logic -> What
        // 실행하는 코드를 어드바이스라고 함
        logger.info("Before Aspect - Method is called - {}", joinpoint);
    }

    // 메서드가 실행되고 난 후
    @After("execution(* com.jewan.learnspringframework.aop.*.*.*(..))")
    public void logMethodCallAfterExecution(Joinpoint joinpoint) {
        logger.info("After Aspect - {} has executed", joinpoint);
    }

    // 메서드가 예외를 던졌을 때
    @AfterThrowing(
            pointcut = "execution(* com.jewan.learnspringframework.aop.*.*.*(..))",
            throwing = "exception"
            )
    public void logMethodCallAfterExeception(Joinpoint joinpoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinpoint, exception);
    }
    
    // 메서드가 정상 동작하였을 때
    @AfterReturning(
            pointcut = "execution(* com.jewan.learnspringframework.aop.*.*.*(..))",
            returning = "resultValue" // 반환값을 매핑
            )
    public void logMethodCallAfterSuccessfulException(Joinpoint joinpoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinpoint, resultValue);
    }
}
