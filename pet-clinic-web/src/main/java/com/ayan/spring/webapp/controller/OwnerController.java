package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields("id");
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

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView modelAndView = new ModelAndView("owner/ownerDetails");
        modelAndView.addObject(ownerService.findById(Long.valueOf(ownerId)));
        return modelAndView;
    }

}
