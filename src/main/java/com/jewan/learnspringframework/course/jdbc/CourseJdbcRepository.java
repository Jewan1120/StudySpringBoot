package com.jewan.learnspringframework.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.jewan.learnspringframework.course.Course;

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

    private static String INSERT_QUERY_PARAM = 
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;

    private static String DELET_QUERY = 
            """
                delete from course
                where id = ?
            """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id = ?
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }

    public void insert(Course course) {
        // 쿼리문의 물음표 순서에 맞게 짝을 이룸
        springJdbcTemplate.update(INSERT_QUERY_PARAM, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELET_QUERY, id);
    }

    public Course findById(long id) {
        // Execute a query for a result object
        // 자동으로 매핑해줌
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
