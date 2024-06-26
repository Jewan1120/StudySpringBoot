package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "jewan", "taekbae", LocalDate.now(), false));
        todos.add(new Todo(++todosCount, "jewan", "shopo", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "jewan", "doldol", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "jewan", "gogo", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String name) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todosCount, username, description, targetDate, done));
    }
}
