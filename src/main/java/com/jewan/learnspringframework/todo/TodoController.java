package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false); // 임의 데이터
        model.put("todo", todo); // model에 todo를 전달해줌 -> JSP의 form에서 사용하기 위함
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(@ModelAttribute("todo") Todo todo, ModelMap model) { // 파라미터를 직접 바인딩 하는 것이 아니라 Object를 전달 받음
        String username = (String) model.get("name"); // 뷰 model 안에 담겨 있던 값
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos"; // URL 재 요청
    }
}
