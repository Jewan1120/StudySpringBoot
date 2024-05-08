package com.jewan.learnspringframework;

import com.jewan.learnspringframework.game.GameRunner;
import com.jewan.learnspringframework.game.MarioGame;
import com.jewan.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        // 클래스를 직접 참조하는 강한 결합
        // var marioGame = new MarioGame();
        // var superContraGame = new SuperContraGame();
        
        // 인터페이스를 이용한 느슨한 결합
        // var game = new SuperContraGame();
        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        // Game 은 GameRunner의 의존성임
        // 이런 의존성, 객체 관리를 모두 스프링이 하도록 함.
        gameRunner.run();
    }

}
