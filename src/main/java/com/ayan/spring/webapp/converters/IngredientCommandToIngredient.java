package com.ayan.spring.webapp.converters;

import com.ayan.spring.webapp.commands.IngredientCommand;
import com.ayan.spring.webapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    final UnitOfMeasureCommandToUnitOfMeasure uomconverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomconverter) {
        this.uomconverter = uomconverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {

        if (source == null)
            return null;

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasure(uomconverter.convert(source.getUnitOfMeasure()));

        return ingredient;
    }
}
