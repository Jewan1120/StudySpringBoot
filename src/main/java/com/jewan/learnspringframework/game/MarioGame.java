package com.jewan.learnspringframework.game;
// 해당 패키지를 찾을 수 있도록 설정해야함

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
// @Component를 사용하여 스프링이 컴포넌트 스캐닝을 할 때, 자동으로 빈으로 등록
// @Component로 인해 스프링이 인스턴스가 생성되고 인스턴스가 자동으로 주입
public class MarioGame implements GamingConsole {

    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Go into a hole");
    }

    public void left() {
        System.out.println("Go back");
    }

    public void right() {
        System.out.println("Accelerate");
    }
}
