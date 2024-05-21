package com.jewan.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.jewan.learnspringframework.game.GameRunner;
import com.jewan.learnspringframework.game.GamingConsole;
import com.jewan.learnspringframework.game.MarioGame;

@Configuration
@ComponentScan("com.jewan.learnspringframework.game")
// 2. @ComponentScan으로 어디를 스캔할 것인지 패키지를 지정해줄 수 있음.
public class GamingConfiguration {

    // @Bean
    // public GamingConsole game() {
    // var game = new MarioGame();
    // return game;
    // }

    // 1. 위를 주석 처리하면 NoSuchBeanDefinitionException가 발생
    // 이유는 스프링이 MarioGame을 찾아야하는 곳을 알려줘야함.

    // 3. @Component로 인해 AutoWiring됨 -> 코드의 양이 상당히 줄음

    // @Bean
    // public GameRunner gameRunner(GamingConsole game) {
    // System.out.println("Parameter : " + game);
    // var gameRunner = new GameRunner(game);
    // return gameRunner;
    // }
}
