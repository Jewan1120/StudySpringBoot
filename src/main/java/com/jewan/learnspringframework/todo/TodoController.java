package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    // /list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("jewan");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    // GET, POST 구분
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage() {
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam("description") String description, ModelMap model) {
        String username = (String) model.get("name"); // 뷰 model 안에 담겨 있던 값
        todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
        return "redirect:list-todos"; // URL 재 요청
    }
}
