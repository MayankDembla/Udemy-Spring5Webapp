package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.ConstructorBasedGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectControllerTest {

    PropertyInjectController propertyInjectController;

    @BeforeEach
    void setUp() {
        propertyInjectController = new PropertyInjectController();
        propertyInjectController.greetingService = new ConstructorBasedGreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(propertyInjectController.getGreeting());
    }

}