package com.tahayvz.sfgdi.controller;

import com.tahayvz.sfgdi.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController constructorInjectedController;

    @BeforeEach
    void setUp(){
        constructorInjectedController = new ConstructorInjectedController(new ConstructorInjectedGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(constructorInjectedController.getGreeting());
    }


}