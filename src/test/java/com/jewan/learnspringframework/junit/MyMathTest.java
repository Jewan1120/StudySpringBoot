package com.jewan.learnspringframework.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; // JUnit5 = Jupiter

class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemeberArray() {
        // 실패가 없으면 통과한다
        // 테스트 조건 = Assert
        // Assert 중 하나라도 실패하면 실패

        // fail("Not yet implemented");

        assertEquals(6, math.calculateSum(new int[] { 1, 2, 3 })); // 예상값, 실제값
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        assertEquals(0, math.calculateSum(new int[] {}));
    }

}
