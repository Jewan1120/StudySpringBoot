package com.jewan.learnspringframework.course;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Course : id, name, author

// @Controller : 일반적인 컨트롤러를 정의, 반환 값은 스프링 MVC의 ViewResolver를 통해 뷰(View)를 나타내는 뷰 이름으로 처리
// @ResponseBody : 반환 값이 HTTP 응답의 본문으로 처리되어 데이터 형식(JSON, XML)으로 클라이언트에 전달

@RestController
// @RestController : @Controller + @ResponseBody
// RESTful 웹 서비스를 제공하는 컨트롤러를 정의할 때 사용되며, 메서드의 반환 값이 JSON, XML 등과 같은 데이터로 처리
public class CourseController {

    // /courses에 맵핑 해주어야함.

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(new Course(1, "Learn AWS", "Jewan"), new Course(2, "Learn DevOps", "Jewan"),
                new Course(3, "Learn AWS", "Jewan"));
        // [{"id":1,"name":"Learn AWS","author":"Jewan"},{"id":2,"name":"Learn
        // DevOps","author":"Jewan"},{"id":3,"name":"Learn AWS","author":"Jewan"}]
    }
}
