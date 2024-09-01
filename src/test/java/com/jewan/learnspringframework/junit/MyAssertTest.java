package com.jewan.learnspringframework.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean test = todos.contains("AWS");
        assertEquals(true, test);
        assertEquals(3, todos.size());
        assertEquals(3, todos.size(), "Error Message");
        assertEquals(new int[] { 1, 2 }, new int[] { 1, 2 }); // 배열 검사하는 메서드는 사라졌나 ... ?
    }
}
