package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    // /list-todos
    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("jewan");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    // GET, POST 구분
    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        // 양방향 바인딩 -> 서비스에서 뷰로 기본 값을 전달
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false); // 임의 데이터
        model.addAttribute("todo", todo); // model에 todo를 전달해줌 -> JSP의 form에서 사용하기 위함
        return "todo";
    }

    @PostMapping("add-todo")
    // 파라미터를 직접 바인딩 하는 것이 아니라 Object를 전달 받음
    // BindingResult를 사용할 때는 @ModelAttribute나 @RequestBody로 바인딩된 객체 바로 뒤에 위치
    public String addNewTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) model.get("name"); // 뷰 model 안에 담겨 있던 값
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos"; // URL 재 요청
    }

    // Delete todo
    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam(name = "id") int id) {
        todoService.deleteById(id);
        return "redirect:list-todos"; // URL 재 요청
    }

    // Update todo
    @GetMapping("update-todo")
    // 메서드 이름을 분명하게 작성
    public String showUpdateTodoPage(@RequestParam(name = "id") int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = (String) model.get("name"); // 뷰 model 안에 담겨 있던 값
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos"; // URL 재 요청
    }

}
