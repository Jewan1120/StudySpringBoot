package com.jewan.learnspringframework;

import com.jewan.learnspringframework.game.GameRunner;
import com.jewan.learnspringframework.game.MarioGame;
import com.jewan.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        // 클래스를 직접 참조하는 강한 결합
        // var marioGame = new MarioGame();
        // var superContraGame = new SuperContraGame();
        
        // 인터페이스를 이용한 느슨한 결합
        // var game = new SuperContraGame();
        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }

}
