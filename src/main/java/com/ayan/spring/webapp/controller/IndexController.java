package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String getindexPage(Model model) {
        log.debug("Getting Index Page !!");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
