package com.jewan.learnspringframework.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    // /list-todos
    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    // GET, POST 구분
    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
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
        String username = getLoggedInUsername(); // 뷰 model 안에 담겨 있던 값
        todo.setUsername(username);

        todoRepository.save(todo); // JPA를 이용해서 Bean에 등록되어있는 값을 자동으로 매핑 후 H2 DB에 Insert

        return "redirect:list-todos"; // URL 재 요청
    }

    // Delete todo
    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam(name = "id") int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos"; // URL 재 요청
    }

    // Update todo
    @GetMapping("update-todo")
    // 메서드 이름을 분명하게 작성
    public String showUpdateTodoPage(@RequestParam(name = "id") int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get(); // Optional을 반환하기 때문에 get을 해줘야함
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername(); // 뷰 model 안에 담겨 있던 값
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos"; // URL 재 요청
    }

    private String getLoggedInUsername() {
        // SpringSecurity에서 닉네임을 직접 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
