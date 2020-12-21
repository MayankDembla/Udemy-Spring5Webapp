package com.ayan.spring.webapp.converters;

import com.ayan.spring.webapp.commands.IngredientCommand;
import com.ayan.spring.webapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    final UnitOfMeasureToUnitOfMeasureCommand converter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.converter = converter;
    }

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {

        if (source == null)
            return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setAmount(source.getAmount());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setUnitOfMeasure(converter.convert(source.getUnitOfMeasure()));

        return ingredientCommand;
    }
}
