package com.ayan.spring.webapp.converters;

import com.ayan.spring.webapp.commands.RecipeCommand;
import com.ayan.spring.webapp.domain.Recipe;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConveter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConveter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null)
            return null;

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(categoryCommand -> recipe.getCategories().add(categoryConveter.convert(categoryCommand)));
        }

        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setCookTime(source.getCookTime());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setUrl(source.getUrl());

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        if (source.getNotes() != null)
            recipe.setNotes(notesConverter.convert(source.getNotes()));

        return recipe;
    }
}
