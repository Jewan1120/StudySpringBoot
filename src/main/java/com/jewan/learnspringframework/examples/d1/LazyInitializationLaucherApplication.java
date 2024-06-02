package com.jewan.learnspringframework.examples.d1;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}


@Component
@Lazy // ClassB를 사용하려 할 때 초기화할 수 있게 함.
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        // 스프링 컨텍스트를 실행하면 자동으로 초기화가 됨.
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationLaucherApplication {

    public static void main(String[] args) {

        try (var context =
                new AnnotationConfigApplicationContext(LazyInitializationLaucherApplication.class)) {
            // Bean을 로드하지 않아도 "Some Initialization Logic"가 자동으로 출력 됨 -> 자동 초기화
            // @Lazy를 사용하면 자동으로 초기화되지 않음.
            // 그럼 초기화되는 시점은 ? -> 빈을 사용하려할 때

            // 자동 초기화되는 컴포넌트
            System.out.println("Initialization of context is Completed");

            // 여기서 지연 초기화가 됨
            context.getBean(ClassB.class).doSomething();
            // Some Initialization Logic
            // Do Something
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
