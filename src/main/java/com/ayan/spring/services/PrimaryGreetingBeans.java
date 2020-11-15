package com.ayan.spring.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingBeans implements GreetingService {


    @Override
    public String getGreeting() {
        return "Hello World - Primary Bean ";
    }
}
