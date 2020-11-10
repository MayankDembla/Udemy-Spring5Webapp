package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.getGreeting();
    }

    public String greetings() {
        return "Hey Buddy, get me out through Spring Context";
    }

}
