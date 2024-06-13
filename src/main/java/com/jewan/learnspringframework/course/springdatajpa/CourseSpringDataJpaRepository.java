package com.jewan.learnspringframework.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jewan.learnspringframework.course.Course;

// Spring Data JPA를 이용할 떈 인터페이스로 구현
// JpaRepository<엔티티의 클래스, 해당 ID값의 자료형>
// 인터페이스만 선언해주면 사용할 수 있음
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

}
