package com.jewan.learnspringframework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jewan.learnspringframework.game.GameRunner;
import com.jewan.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {

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
