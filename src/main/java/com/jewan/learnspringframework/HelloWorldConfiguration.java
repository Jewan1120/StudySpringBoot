package com.jewan.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};
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
    public int age() {
        return 26;
    }

    // 컨테이너에 값을 저장하는 방법
    // 1. 하드코딩
    @Bean
    public Person person() {
        return new Person("Taekbae", 10, new Address("Anjung", "PyeongTaek"));
    }

    // 2. 메서드 호출
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 3. 파라미터로 전달
    @Bean
    public Person person3Parameters(String name, int age, Address address2) { // 파라미터로 전달할 때는 Bean의 이름이 들어가야함.
        return new Person(name, age, address2); // 기존에 컨테이너에 등록한 name, age
    }

    @Bean(name = "address2") // name 속성을 부여하여 빈의 이름을 바꾸어줄 수 있음.
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
