package com.tahayvz.sfgdi.controller;

import com.tahayvz.sfgdi.services.SetterInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp() {
        setterInjectedController = new SetterInjectedController();

        setterInjectedController.setGreetingService(new SetterInjectedGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(setterInjectedController.getGreeting());
    }
}