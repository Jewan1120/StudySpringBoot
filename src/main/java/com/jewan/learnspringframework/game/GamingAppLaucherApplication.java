package com.jewan.learnspringframework.game;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.jewan.learnspringframework.GamingConfiguration;

@Configuration
@ComponentScan("com.jewan.learnspringframework.game")
public class GamingAppLaucherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up(); // Jump
            context.getBean(GameRunner.class).run();
        }
        catch (BeansException e) {
            e.printStackTrace();
        }

    }

}
