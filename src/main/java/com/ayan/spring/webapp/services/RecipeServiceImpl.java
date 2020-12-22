package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.commands.RecipeCommand;
import com.ayan.spring.webapp.converters.RecipeCommandToRecipe;
import com.ayan.spring.webapp.converters.RecipeToRecipeCommand;
import com.ayan.spring.webapp.domain.Recipe;
import com.ayan.spring.webapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe toRecipe;
    private final RecipeToRecipeCommand toRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe toRecipe, RecipeToRecipeCommand toRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.toRecipe = toRecipe;
        this.toRecipeCommand = toRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in service...");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long l) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent())
            throw new RuntimeException("Recipe Not Found");

        return recipeOptional.get();
    }

    @Override
    public RecipeCommand findCommandById(long id) {
        return toRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = toRecipe.convert(recipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe : " + savedRecipe);

        return toRecipeCommand.convert(savedRecipe);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            recipeRepository.deleteById(id);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
