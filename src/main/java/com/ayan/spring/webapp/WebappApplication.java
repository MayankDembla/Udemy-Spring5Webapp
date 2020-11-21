package com.ayan.spring.webapp;

import com.ayan.spring.webapp.controller.*;
import com.ayan.spring.webapp.examplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.ayan.spring")
@ImportResource("classpath:chuck-config.xml")
public class WebappApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(WebappApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println(controller.greetings());

        System.out.println("---- Property Based ");
        PropertyInjectController propertyInjectController = (PropertyInjectController) ctx.getBean("propertyInjectController");
        System.out.println(propertyInjectController.getGreeting());

        System.out.println("---- Setter Based ");
        SetterInjectContoller setterInjectContoller = (SetterInjectContoller) ctx.getBean("setterInjectContoller");
        System.out.println(setterInjectContoller.getGreeting());

        System.out.println("---- Constructor Based ");
        ConstructorBasedInjectController constructorBasedInjectController = (ConstructorBasedInjectController) ctx.getBean("constructorBasedInjectController");
        System.out.println(constructorBasedInjectController.getGreeting());

        System.out.println("--- Primary Bean ");
        controller.sayHello();
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

        System.out.println("--- i18 Controller --");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        System.out.println("External Property Configuration");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getUrl());

    }

}
