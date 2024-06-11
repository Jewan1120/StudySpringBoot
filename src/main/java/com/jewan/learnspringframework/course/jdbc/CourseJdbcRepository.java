package com.jewan.learnspringframework.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = 
            // 텍스트 블록
            """
                insert into course (id, name, author)
                values(1, 'Learn AWS', 'Jewan');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
