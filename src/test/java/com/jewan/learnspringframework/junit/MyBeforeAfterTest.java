package com.jewan.learnspringframework.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll() { // 클래스 레벨 메서드기 때문에 정적으로 설정
        System.out.println("BeforeAll");
    }

    @BeforeEach // 테스트 전에 각각 실행
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }
}
