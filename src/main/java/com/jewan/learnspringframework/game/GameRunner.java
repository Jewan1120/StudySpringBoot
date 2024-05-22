package com.jewan.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole game; // 느슨한 결합을 위해 인터페이스를 참조

    // 이 부분을 느슨한 결합으로 바꾸어 줘야함.
    public GameRunner(@Qualifier("MarioGameQualifier") GamingConsole game) {
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
    // 차 - 바퀴 : 느슨한 결합
    // 엔진 박살나면 차도 박살이지만, 바퀴가 박살난다고 해서 차가 박살나지 않음. 갈아끼우면 그만.

    // 느슨한 결합으로 인해 참조하던 클래스에 수정이 이루어져도 해당 소스엔 변화 없음.
}
