package com.ayan.spring.webapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository {

    public String getEnglishGreeting();

    public String getSpanishGreeting();

    public String getGermanGreeting();
}
