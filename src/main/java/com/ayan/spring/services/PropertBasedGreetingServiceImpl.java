package com.ayan.spring.services;

import org.springframework.stereotype.Service;

@Service
public class PropertBasedGreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello World - Property Based Service Impl";
    }
}
