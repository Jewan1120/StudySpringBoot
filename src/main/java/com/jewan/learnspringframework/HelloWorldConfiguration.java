package com.jewan.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};

record Address(String firstLine, String city) {};
// JDK 16에서 추가된 기능
// 불변(immutable) 데이터를 나타내는 클래스
// 자바 Bean을 만드는 번거로움(보일러 플레이트 코드)을 줄여줌
// eqauls, hashCode, toString, 생성자, Getter가 자동으로 생성
// 불변이기 때문에 Setter는 없음.


@Configuration // 수동으로 스프링 빈 등록을 위한 어노테이션
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Jewan";
    }

    @Bean
    public String age() {
        return "26";
    }

    @Bean
    public Person person() {
        return new Person("Taekbae", 10);
    }
    
    @Bean
    public Address address() {
        return new Address("Nippori", "Tokyo");
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
