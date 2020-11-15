package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectContoller {

    private GreetingService greetingService;

    @Qualifier("setterBasedGreetingsService")
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.getGreeting();
    }
}
