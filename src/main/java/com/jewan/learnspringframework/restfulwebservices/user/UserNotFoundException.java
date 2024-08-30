package com.jewan.learnspringframework.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // 상황에 맞게 응답상태를 전달
// (type=Internal Server Error, status=500). 에서 (type=Not Found, status=404). 로 변경됨
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
