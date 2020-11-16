package com.ayan.spring.services;

import com.ayan.spring.webapp.repository.GreetingRepository;

public class PrimarySpanishGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}
