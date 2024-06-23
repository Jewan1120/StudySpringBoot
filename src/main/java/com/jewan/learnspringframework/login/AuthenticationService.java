package com.jewan.learnspringframework.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String user, String password) {
        
        boolean isValidUserName = user.equalsIgnoreCase("jewan");
        boolean isValidPassword = password.equalsIgnoreCase("taekbae");
        
        return isValidUserName && isValidPassword;
    }
}
