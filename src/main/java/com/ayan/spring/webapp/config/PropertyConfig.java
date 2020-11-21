package com.ayan.spring.webapp.config;

import com.ayan.spring.webapp.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class PropertyConfig {

    @Value("com.ayan.user")
    private String username;

    @Value("com.ayan.password")
    private String password;

    @Value("com.ayan.url")
    private String url;

    @Bean
    public FakeDataSource fakeDataSource() {
        return FakeDataSource.builder().user(username).password(password).url(url).build();
    }

    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
