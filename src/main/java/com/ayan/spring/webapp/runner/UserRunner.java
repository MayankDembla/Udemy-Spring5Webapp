package com.ayan.spring.webapp.runner;

import com.ayan.spring.webapp.model.User;
import com.ayan.spring.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        try {
            User user = new User("Ma", "ops", 12000L);
            User user1 = new User("Nan", "opsa", 16000L);

            userService.insert(Arrays.asList(user, user1));

        } catch (RuntimeException e) {
            System.out.println("Exception in batch 1...! " + e.getMessage());
        }

        // Spring creates the Another transaction when a particular segment is called..
        try {
            User user2 = new User("Anubhooti", "opsb", 32000L);
            User user3 = new User("Kori", "opsb", 32000L);

            userService.insert(Arrays.asList(user2, user3));

        } catch (RuntimeException e) {
            System.out.println("Exception... in batch 2 ! " + e.getMessage());
        }

        System.out.println(userService.getUser());
    }
}
