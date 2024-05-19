package com.jewan.learnspringframework.test;

import java.io.Serializable;

class Pojo {
    // POJO : Plain Old Java Object = 자바로 생성한 순수한 객체
    // 즉, 모든 자바 객체는 POJO
    // 특정 환경이나 기술에 종속적이지 않으면 재사용이 가능하고, 확장 가능한 유연한 코드를 작성할 수 있다.
    // Getter, Setter를 가짐

    private String text;
    private int num;

    public String toString() {
        return text + ":" + num;
    }
}


class JavaBean implements Serializable {

    private String text;
    private int num;

    // 1. 인수가 없는 생성자 (기본 생성자)
    public JavaBean() {

    }

    // 2. Getter, Setter
    // 프로퍼티에 접근

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    // 3. Serializable를 구현
}

// 스프링 빈 : 스프링에 관리되는 모든 자바 객체
// IoC(Inversion of Control) 컨테이너가 관리하는 모든 자바 빈을 지칭함


public class SpringBeanVsJavaBean {

    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        System.out.println(pojo); // null:0
    }
}
