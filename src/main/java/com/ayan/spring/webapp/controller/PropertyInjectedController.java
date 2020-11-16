package com.ayan.spring.webapp.controller;

import com.ayan.spring.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("propertBasedGreetingServiceImpl")
    public GreetingService greetingServiceImpl;

    public String sayHello() {
        return greetingServiceImpl.getGreeting();
    }

}
