package com.ayan.spring.webapp;

import com.ayan.spring.webapp.controller.ConstructorBasedInjectController;
import com.ayan.spring.webapp.controller.MyController;
import com.ayan.spring.webapp.controller.PropertyInjectController;
import com.ayan.spring.webapp.controller.SetterInjectContoller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
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

    }

}
