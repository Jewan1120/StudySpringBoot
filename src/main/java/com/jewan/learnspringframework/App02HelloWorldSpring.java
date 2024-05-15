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

        System.out.println(context.getBean("age")); // 26

        // context.getBean("person").toString()
        System.out.println(context.getBean("person")); // Person[name=Taekbae, age=10]
        System.out.println(context.getBean("person2MethodCall")); // Person[name=Jewan, age=26]
        System.out.println(context.getBean("person3Parameters"));

        // Person[name=Taekbae, age=10, address=Address[firstLine=Anjung, city=PyeongTaek]]
        // Person[name=Jewan, age=26, address=Address[firstLine=Nippori, city=Tokyo]]
        // Person[name=Jewan, age=26, address=Address[firstLine=Nippori, city=Tokyo]]

        // System.out.println(context.getBean("address")); // Address[firstLine=Nippori, city=Tokyo]
        // @Bean의 name을 address2로 변경했기 때문에 컨테이너에서 값을 가져올 때도 address2
        System.out.println(context.getBean("address2"));

        // 클래스 자체를 가져와버려도 됨 -> record도 클래스 ? true
        System.out.println(context.getBean(Address.class));

    }
}
