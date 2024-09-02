package com.jewan.learnspringframework.security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityPlayResource {

    @GetMapping("/csrf-token")
    public CsrfToken getMethodName(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
        // 세션을 사용하지 않는다면 CSRF는 필요하지 않음 -> 일반적으로 세션이나 세션 쿠키와 관련
        // 상태를 저장하지 않는 RestAPI 같은 경우는 CSRF가 필요하지 않음 -> CSRF를 사용해제
    }

}
