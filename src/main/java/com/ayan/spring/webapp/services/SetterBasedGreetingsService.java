package com.ayan.spring.webapp.services;

import org.springframework.stereotype.Service;

@Service
public class SetterBasedGreetingsService implements GreetingService {


    @Override
    public String getGreeting() {
        return "Hello World - Setter Based Greetings Controller";
    }
}
