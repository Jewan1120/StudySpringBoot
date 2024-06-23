package com.jewan.learnspringframework.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    // @Autowired 생략 가능
    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET) // Get 방식 요청
    public String gotoLoginPage() { // String으로 파라미터 전달 받음
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST) // Get 방식 요청
    public String gotoWelcomePage(@RequestParam("name") String name,
            @RequestParam("password") String password, ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            // model.put("password", password);
            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials");
        return "login";
    }
}
