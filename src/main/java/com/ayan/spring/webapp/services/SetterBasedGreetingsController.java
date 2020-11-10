package com.ayan.spring.webapp.services;

import org.springframework.stereotype.Service;

@Service
public class SetterBasedGreetingsController implements GreetingService {


    @Override
    public String getGreeting() {
        return "Hello World - Setter Based Greetings Controller";
    }
}
