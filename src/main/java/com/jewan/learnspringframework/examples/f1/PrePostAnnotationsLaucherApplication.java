package com.jewan.learnspringframework.examples.f1;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
    private SomeDependnecy someDependnecy;

    public SomeClass(SomeDependnecy someDependnecy) {
        super();
        this.someDependnecy = someDependnecy;
        System.out.println("All Dependency are Ready");
    }

    
    
    @PostConstruct
    // 의존성 주입이 이루어진 직후에 초기화를 수행하는 메서드
    // Bean의 LifeCycle에서 오직 한번만 실행됨
    public void initialize() {
        someDependnecy.getReady();
    }
    
    @PreDestroy
    // 객체를 제거하기 전에 수행하는 CallBack 메서드에 사용
    public void cleanUp() {
        System.out.println("CleanUp");
    }
}


@Component
class SomeDependnecy {
    public void getReady() {
        System.out.println("Some Logic using SomeDependency");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsLaucherApplication {

    public static void main(String[] args) {

        try (var context =
                new AnnotationConfigApplicationContext(PrePostAnnotationsLaucherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
