package com.jewan.learnspringframework.examples.a1;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

    // @Autowired로 자동으로 의존성을 주입해줌
    // Spring은 객체를 생성할 때 가장 먼저 생성자를 통해 의존성을 주입
    // 생성자 주입은 의존성을 명확하게 표시
    // 메서드 하나로 모든 필드에 의존성 주입 가능

    // 1. 필드 주입
    // @Autowired
    Dependency1 dependency1;

    // @Autowired
    Dependency2 dependency2;

    // 2. Setter 주입
    // @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }

    // @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }

    // 3. 생성자 주입
    // 해당 어노테이션이 불필요하다고 나오는 이유로, Spring 4.3 이후 버전부터는
    // 만약 클래스에 생성자가 하나만 있고 그 생성자가 의존성을 받는다면,
    // @Autowired 애너테이션을 생략해도 Spring이 자동으로 의존성을 주입
    // @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }

}


@Component
class Dependency1 {

}


@Component
class Dependency2 {

}


@Configuration // @Configuration를 사용하면 자동으로 빈으로 등록됨
// @ComponentScan("com.jewan.learnspringframework.examples.a1")
// 같은 패키지안의 클래스는 경로를 적어주지 않아도 자동으로 스캔함
@ComponentScan
public class DepInjectionLaucherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLaucherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            // 빈 이름으로 찾는 것보다 타입으로 찾는 것이 더 나음
            System.out.println(context.getBean(YourBusinessClass.class));
            // 1. DI(Dependency Injection) 이전 출력 : Using null and null
            // 2. @Autowired 이후 출력 : Using com.jewan.learnspringframework.examples.a1.Dependency1@69c81773
            // and com.jewan.learnspringframework.examples.a1.Dependency2@4d14b6c2
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
