package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.domain.Category;
import com.ayan.spring.webapp.domain.UnitOfMeasure;
import com.ayan.spring.webapp.repositories.CategoryRepository;
import com.ayan.spring.webapp.repositories.UnitofMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitofMeasureRepository unitofMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitofMeasureRepository unitofMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitofMeasureRepository = unitofMeasureRepository;
    }


    @GetMapping(value = {"", "/", "/index"})
    public String getindexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitofMeasureRepository.findByDescription("Pinch");

        System.out.println("Cat Id is " + categoryOptional.get().getId());
        System.out.println("UM ID id : " + unitOfMeasureOptional.get().getId());

        return "index";
    }



}
