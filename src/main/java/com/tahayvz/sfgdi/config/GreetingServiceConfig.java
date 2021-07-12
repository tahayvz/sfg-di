package com.tahayvz.sfgdi.config;

import com.tahayvz.sfgdi.repositories.EnglishGreetingRepository;
import com.tahayvz.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.tahayvz.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"TR", "default"})
    @Bean("i18NTurkishGreetingService")
    I18NTurkishGreetingService i18NTurkishGreetingService(){
        return new I18NTurkishGreetingService();
    }

    @Profile("ES")
    @Bean("i18nService")
    I18NSpanishGreetingService i18NSpanishService(){
        return new I18NSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
}
