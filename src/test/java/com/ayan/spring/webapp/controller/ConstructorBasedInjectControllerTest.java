package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.ConstructorBasedGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorBasedInjectControllerTest {

    ConstructorBasedInjectController constructorBasedInjectController;

    @BeforeEach
    void setUp() {
        constructorBasedInjectController = new ConstructorBasedInjectController(new ConstructorBasedGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(constructorBasedInjectController.getGreeting());
    }
}