package com.ayan.spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping(value = {"", "/", "/index"})
    public static String getindexPage() {
        System.out.println("Hello buddy");
        return "index";
    }

}
