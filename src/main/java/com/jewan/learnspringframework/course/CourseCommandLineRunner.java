package com.jewan.learnspringframework.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.jewan.learnspringframework.course.jpa.CourseJpaRepository;
import com.jewan.learnspringframework.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    // 빈이 SpringApplication 안에 포함되어 있을 때 실행
    // Spring 애플리케이션이 시작 시에 실행될 로직이 있을 때 CommandLineRunner 사용

    // 1. JDBC를 사용하는 경우
    // @Autowired
    // private CourseJdbcRepository repository;

    // 2. JPA를 사용하는 경우
    // @Autowired
    // private CourseJpaRepository repository;

    // 3. Spring Data JPA
    @Autowired
    private CourseSpringDataJpaRepository repository;
    // 1, 2번의 경우 insert메서드를 사용했지만
    // 3번의 경우엔 save라는 메서드 사용

    @Override
    public void run(String... args) throws Exception {
        // repository.insert(new Course(1, "Learn Taekbae", "Jewan"));
        // repository.insert(new Course(2, "Learn Cat", "Taekbae"));
        // repository.insert(new Course(3, "Learn Jewan", "Shopho"));
        repository.save(new Course(1, "Learn Taekbae", "Jewan"));
        repository.save(new Course(2, "Learn Cat", "Taekbae"));
        repository.save(new Course(3, "Learn Jewan", "Shopho"));
        // repository.deleteById(1);
        repository.deleteById(1L);

        // System.out.println(repository.findById(2));
        // System.out.println(repository.findById(3));
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        // Course [id=2, name=Learn Cat, author=Taekbae]
        // Course [id=3, name=Learn Jewna, author=Shopho]

    }

}
