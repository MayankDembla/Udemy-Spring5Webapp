package com.ayan.spring.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nServiceEn")
public class I18nEnglishService implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello World - English ";
    }
}
