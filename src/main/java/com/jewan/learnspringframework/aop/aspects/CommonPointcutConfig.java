package com.jewan.learnspringframework.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class CommonPointcutConfig {

    @Pointcut("execution(* com.jewan.learnspringframework.aop.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.jewan.learnspringframework.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {
    }

    @Pointcut("execution(* com.jewan.learnspringframework.aop.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("bean(*Srervice*)")
    public void allPackageConfigUsingBean() {
    }

    // Common으로 Pointcut을 미리 정의해놓은 뒤,
    // Pointcut에 값을 넣을 때 이 클래스를 지정하게 하면 됨.
}
