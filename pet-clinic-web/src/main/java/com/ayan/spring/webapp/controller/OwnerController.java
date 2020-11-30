package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getOwner(Model model) {

        System.out.println(ownerService.findAll());
        model.addAttribute("owners", ownerService.findAll());

        return "/owner/index";
    }

    @RequestMapping("/find")
    public String findOwners() {
        return "notImplemented";
    }

}
