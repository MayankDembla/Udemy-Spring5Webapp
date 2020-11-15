package com.ayan.spring.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The Lifecycle has its property Set ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle Bean has been terminated ");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("My Bean Name is :  " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application Context has been Set ");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## the post construct method has been called");
    }

    @PreDestroy
    public void predestroy() {
        System.out.println("The Pre Destory method has been called ");
    }

    public void beforeInit() {
        System.out.println("## Before Init of the Bean ");
    }

    public void afterInit() {
        System.out.println("## After Init of the Bean ");
    }
}
