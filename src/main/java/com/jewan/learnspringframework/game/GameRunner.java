package com.jewan.learnspringframework.game;

public class GameRunner {

    MarioGame game;

    public GameRunner(MarioGame game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game : " + game); // 로깅 프레임워크 사용하는 것이 더 좋음
        game.up();
        game.down();
        game.left();
        game.right();
    }

}
