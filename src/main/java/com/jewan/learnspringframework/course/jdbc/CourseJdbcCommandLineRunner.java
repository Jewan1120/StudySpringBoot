package com.jewan.learnspringframework.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.jewan.learnspringframework.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    // 빈이 SpringApplication 안에 포함되어 있을 때 실행
    // Spring 애플리케이션이 시작 시에 실행될 로직이 있을 때 CommandLineRunner 사용

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert();
        repository.insert(new Course(2, "Learn Cat", "Taekbae"));
        repository.insert(new Course(3, "Learn Jewna", "Shopho"));
        repository.deleteById(1);
    }

}
