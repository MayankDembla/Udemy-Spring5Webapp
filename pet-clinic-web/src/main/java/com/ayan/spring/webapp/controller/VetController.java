package com.ayan.spring.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

//    private final VetService vetService ;
//
//    public VetController(VetService vetService) {
//        this.vetService = vetService;
//    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets() {

        // model.addAttribute("vets",vetService.findAll()) ;

        return "/vets/index";
    }

}
