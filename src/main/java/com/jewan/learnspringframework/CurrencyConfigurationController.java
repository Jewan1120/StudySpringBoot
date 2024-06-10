package com.jewan.learnspringframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return configuration;
        // {
        // "url": "http://default.jewan.com",
        // "username": "defaultusername",
        // "key": "defaultkey"
        // }

        // {
        // "url": "http://dev.jewan.com",
        // "username": "devtusername",
        // "key": "devtkey"
        // }
    }
}
