package com.ayan.spring.webapp.controllers;

import com.ayan.spring.webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/author")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        authorRepository.findAll().forEach(a -> a.getBooks().forEach(b -> System.out.println(a + " " + b)));

        return "authors/list";
    }


}
