package com.ayan.spring.webapp.config;

import com.ayan.spring.webapp.examplebeans.FakeDataSource;
import com.ayan.spring.webapp.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({@PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")})
public class PropertyConfig {

    @Value("${com.ayan.user}")
    String username;

    @Value("${com.ayan.password}")
    String password;

    @Value("${com.ayan.url}")
    String url;

    @Value("${com.ayan.jmsuser}")
    String jmsuser;

    @Value("${com.ayan.jmspass}")
    String jmspass;

    @Value("${com.ayan.jmsurl}")
    String jmsurl;

    @Bean
    public FakeDataSource fakeDataSource() {
        return FakeDataSource.builder().user(username).password(password).url(url).build();
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        return FakeJmsBroker.builder().user(jmsuser).password(jmspass).url(jmsurl).build();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
