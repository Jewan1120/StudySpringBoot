package com.jewan.learnspringframework.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login") // /login?name=Jewan
    public String gotoLoginPage(@RequestParam("name") String name, ModelMap model) { // String으로 파라미터 전달 받음
        return "login";
    }
}
