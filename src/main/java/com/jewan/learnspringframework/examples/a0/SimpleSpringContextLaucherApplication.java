package com.jewan.learnspringframework.examples.a0;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.jewan.learnspringframework.examples.a1.DepInjectionLaucherApplication;

@Configuration
@ComponentScan
public class SimpleSpringContextLaucherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLaucherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
