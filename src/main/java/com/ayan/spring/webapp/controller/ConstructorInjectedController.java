package com.ayan.spring.webapp.controller;

import com.ayan.spring.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;

    public ConstructorInjectedController(@Qualifier("constructorBasedGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.getGreeting();
    }
}
