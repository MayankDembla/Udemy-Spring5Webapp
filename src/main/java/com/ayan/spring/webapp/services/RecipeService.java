package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.commands.RecipeCommand;
import com.ayan.spring.webapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    boolean deleteById(Long id);
}
