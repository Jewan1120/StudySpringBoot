package com.jewan.learnspringframework.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API를 사용하기 위한 어노테이션
@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // Path Parameters
    // {}로 감싸서 전달할 수 있음
    @GetMapping("hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello %s", name));
    }
}
