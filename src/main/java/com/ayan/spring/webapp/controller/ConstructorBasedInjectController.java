package com.ayan.spring.webapp.controller;

import com.ayan.spring.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorBasedInjectController {

    private final GreetingService greetingService;

    public ConstructorBasedInjectController(@Qualifier("constructorBasedGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.getGreeting();
    }
}
