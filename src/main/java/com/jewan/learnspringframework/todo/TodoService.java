package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "jewan", "taekbae", LocalDate.now(), false));
        todos.add(new Todo(2, "jewan", "shopo", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(3, "jewan", "doldol", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(4, "jewan", "gogo", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String name) {
        return todos;
    }
}
