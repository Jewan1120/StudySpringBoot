package com.jewan.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 수동으로 스프링 빈 등록을 위한 어노테이션
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Jewan";
    }

}

// 스프링 빈
// Spring의 DI Container에 의해 관리되는 POJO(Plain Old Java Object)
// 스프링은 컴포넌트 스캔을 사용해 @Configuration이 있는 클래스를 찾아서 자동으로 빈 등록

// @Bean *자바 코드로 표현되는 메타정보
// - 메서드 단위
// - 수동으로 스프링 컨테이너에 빈 등록
// - @Configuration 안에 @Bean으로 등록하는 방식

// @Component
// - 클래스 단위
// - 컴포넌트 스캔으로 인해 자동으로 빈 등록
