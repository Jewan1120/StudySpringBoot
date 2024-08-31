package com.jewan.learnspringframework.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public List<SomeBean> filtering() {
        // 두번째 field를 생략함
        return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
    }
}
