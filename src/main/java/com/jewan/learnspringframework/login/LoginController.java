package com.jewan.learnspringframework.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login") // /login?name=Jewan
    public String gotoLoginPage(@RequestParam("name") String name, ModelMap model) { // String으로 파라미터 전달 받음
        // @RequestParam("파라미터 명")의 파라미터명을 적어줘야함

        model.put("name", name); // 모델에서 값이 뷰로 자동으로 전달 jsp에서 ${}로 값 꺼내 씀
        System.out.println("Request param is " + name); // 권장되진 않는 출력
        return "login";
    }
}
