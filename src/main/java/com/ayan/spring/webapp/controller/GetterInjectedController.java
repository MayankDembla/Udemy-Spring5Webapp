package com.ayan.spring.webapp.controller;

import com.ayan.spring.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.getGreeting();
    }

    @Autowired
    public void setGreetingService(@Qualifier("setterBasedGreetingsService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
