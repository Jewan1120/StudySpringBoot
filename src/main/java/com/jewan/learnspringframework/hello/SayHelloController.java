package com.jewan.learnspringframework.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody // @ResponseBody를 사용하면 전달하는 것을 그대로 출력해줌 Hello! What are you doing
    public String sayHello() {
        // Controller에서 String을 전달하면 Spring MVC는 해당 이름으로 된 뷰를 찾음
        return "Hello! What are you doing";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My Stupid HTML</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Use .html");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString(); // 이런 멍청한 짓 그만! 뷰를 이용
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        // Controller에서 String을 전달하면 Spring MVC는 해당 이름으로 된 뷰를 찾음
        return "sayHello";
    }
}
