package com.jewan.learnspringframework.examples.h1;

import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jewan.learnspringframework.game.GameRunner;

// @Configuration 자바를 설정파일로 사용
@ComponentScan
public class xmlConfigurationContextLaucherApplication {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            // xml을 설정파일로 사용
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name")); // xml Bean설정의 id 값으로
            // name
            // Jewan
            System.out.println(context.getBean("age"));
            // 27

            context.getBean(GameRunner.class).run();
            // Running game : com.jewan.learnspringframework.game.MarioGame@5fbdfdcf
            // Jump
            // Go into a hole
            // Go back
            // Accelerate
        }
        catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
