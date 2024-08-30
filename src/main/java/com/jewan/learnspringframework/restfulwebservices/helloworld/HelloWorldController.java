package com.jewan.learnspringframework.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// REST API를 사용하기 위한 어노테이션
@RestController
public class HelloWorldController {

    private MessageSource messageSource; // 메세지 소스 처리하는 전략 인터페이스

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    // 언어 별로 다른 문구 출력
    @GetMapping("hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale(); // Accept 헤더를 감지
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
