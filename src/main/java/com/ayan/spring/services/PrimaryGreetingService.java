package com.ayan.spring.services;

import com.ayan.spring.webapp.repository.GreetingRepository;

public class PrimaryGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    public PrimaryGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String getGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
