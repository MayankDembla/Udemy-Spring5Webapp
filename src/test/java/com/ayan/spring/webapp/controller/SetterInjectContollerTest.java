package com.ayan.spring.webapp.controller;

import com.ayan.spring.services.ConstructorBasedGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectContollerTest {

    SetterInjectContoller setterInjectContoller;

    @BeforeEach
    void setUp() {
        setterInjectContoller = new SetterInjectContoller();
        setterInjectContoller.setGreetingService(new ConstructorBasedGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(setterInjectContoller.getGreeting());
    }
}