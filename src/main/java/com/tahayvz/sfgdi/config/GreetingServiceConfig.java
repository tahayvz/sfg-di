package com.tahayvz.sfgdi.config;

import com.tahayvz.pets.PetService;
import com.tahayvz.pets.PetServiceFactory;
import com.tahayvz.sfgdi.datasource.FakeDataSource;
import com.tahayvz.sfgdi.repositories.EnglishGreetingRepository;
import com.tahayvz.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.tahayvz.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SfgConstructorConfig.class)
//@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
//    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
//                                  @Value("${guru.password}") String password,
//                                  @Value("${guru.jdbcurl}") String jdbcurl){
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcurl(jdbcurl);

//    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration){
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(sfgConfiguration.getUsername());
//        fakeDataSource.setPassword(sfgConfiguration.getPassword());
//        fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());

    FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
        fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"TR", "default"})
    @Bean("i18nService")
    I18NTurkishGreetingService i18NTurkishGreetingService(){
        return new I18NTurkishGreetingService();
    }

    @Profile("ES")
    @Bean("i18nSpanishService")
    I18NSpanishGreetingService i18NSpanishService(){
        return new I18NSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nEnglishService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

//    @Bean
//    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
//        return new ConstructorInjectedGreetingService();
//    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
}
