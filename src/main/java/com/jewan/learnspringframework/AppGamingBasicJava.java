package com.jewan.learnspringframework;

import com.jewan.learnspringframework.game.GameRunner;
import com.jewan.learnspringframework.game.MarioGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
        // Running game : com.jewan.learnspringframework.game.MarioGame@28a418fc
        // Jump
        // Go into a hole
        // Go back
        // Accelerate
    }

}
