package com.jewan.learnspringframework.game;

public class GameRunner {

    private SuperContraGame game;

    public GameRunner(SuperContraGame game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game : " + game); // 로깅 프레임워크 사용하는 것이 더 좋음
        game.up();
        game.down();
        game.left();
        game.right();
    }
    // Coupling : 얼마나 많은 작업이 관련되어있는가 ?
    // ex) 차 - 엔진 : 강한 결합
    //     차 - 바퀴 : 느슨한 결합
    // 엔진 박살나면 차도 박살이지만, 바퀴가 박살난다고 해서 차가 박살나지 않음. 갈아끼우면 그만.
}
