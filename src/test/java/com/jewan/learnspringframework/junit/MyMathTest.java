package com.jewan.learnspringframework.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; // JUnit5 = Jupiter

class MyMathTest {

    @Test
    void test() {
        // 실패가 없으면 통과한다
        // 테스트 조건 = Assert
        // Assert 중 하나라도 실패하면 실패

        // fail("Not yet implemented");

        int[] numbers = { 1, 2, 3 };
        MyMath math = new MyMath();
        int result = math.calculateSum(numbers);
        System.out.println(result); // 해당 출력이 예상값과 일치하는지 작성

        int expectedResult = 5; // 예상값
        assertEquals(expectedResult, result); // 예상값, 실제값
    }

}
