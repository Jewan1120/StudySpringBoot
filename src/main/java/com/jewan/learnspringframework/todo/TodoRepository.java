package com.jewan.learnspringframework.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username); // 이렇게만 적어도 쿼리를 자동으로 생성해줌
}
