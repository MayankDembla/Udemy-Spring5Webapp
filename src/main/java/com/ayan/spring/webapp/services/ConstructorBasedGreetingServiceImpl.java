package com.ayan.spring.webapp.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorBasedGreetingServiceImpl implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello World- Constructor Based Service Implementation";
    }
}