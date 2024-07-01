package com.jewan.learnspringframework.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/") // Get 방식 요청
    public String gotoWelcomePage(ModelMap model) { // String으로 파라미터 전달 받음
        model.addAttribute("name", "Jewan");
        return "welcome";
    }
}
