package com.jewan.learnspringframework.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/") // Get 방식 요청
    public String gotoWelcomePage(ModelMap model) { // String으로 파라미터 전달 받음
        model.addAttribute("name", getLoggedinUsername()); // 하드코딩 되어있던 이름을 SpringSecurity에서 가져오도록 변경
        return "welcome";
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
