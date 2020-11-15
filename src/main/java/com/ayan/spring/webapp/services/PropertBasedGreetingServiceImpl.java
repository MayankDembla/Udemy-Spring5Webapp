package com.ayan.spring.webapp.services;

import org.springframework.stereotype.Service;

@Service
public class PropertBasedGreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello World - Property Based Service Impl";
    }
}
