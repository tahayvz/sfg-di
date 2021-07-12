package com.tahayvz.sfgdi.controller;

import com.tahayvz.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp() {
        setterInjectedController = new SetterInjectedController();

        setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting(){
        System.out.println(setterInjectedController.getGreeting());
    }
}