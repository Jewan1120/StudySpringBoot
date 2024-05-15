package com.jewan.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // 1. 스프링 애플리케이션이나 스프링 컨텍스트 실행

        // @param componentClasses
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // 2. 스프링 프레임워크가 관리하도록 설정 -> @Configuration 클래스
        // HelloWorldConfiguration - @Configuration
        // name - @Bean

        // 3. 스프링에서 관리되는 빈 검색
        // @Bean의 메서드의 이름으로 가져옴
        System.out.println(context.getBean("name")); // Jewan
    }

}
