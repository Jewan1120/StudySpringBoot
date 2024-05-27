package com.jewan.learnspringframework.examples.c1;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLaucherApplication {

    public static void main(String[] args) {

        try (var context =
                new AnnotationConfigApplicationContext(RealWorldSpringContextLaucherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
            // Primary가 있는 Component를 우선적으로 주입받아서 호출
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
