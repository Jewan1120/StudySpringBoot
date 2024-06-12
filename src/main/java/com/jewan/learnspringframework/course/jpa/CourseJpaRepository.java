package com.jewan.learnspringframework.course.jpa;

import org.springframework.stereotype.Repository;
import com.jewan.learnspringframework.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository // DB와 연동할 컴포넌트
@Transactional // 트랜젝션을 허용해주어야함
public class CourseJpaRepository {
    // EntityManager를 이용해서 Entity를 관리

    // @Autowired를 사용해도 되지만, 좀 더 구체적인 어노테이션 사용
    @PersistenceContext
    // Expresses a dependency on a container-managed EntityManager
    // and itsassociated persistence context.
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course); // 테이블에 삽입해주는 메서드
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id); // 지울 때는 객체를 전달해야하므로 find
        entityManager.remove(course);
    }
}
