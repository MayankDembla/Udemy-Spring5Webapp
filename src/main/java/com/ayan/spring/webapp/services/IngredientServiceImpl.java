package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.commands.IngredientCommand;
import com.ayan.spring.webapp.converters.IngredientCommandToIngredient;
import com.ayan.spring.webapp.converters.IngredientToIngredientCommand;
import com.ayan.spring.webapp.domain.Ingredient;
import com.ayan.spring.webapp.domain.Recipe;
import com.ayan.spring.webapp.repositories.IngredientRepository;
import com.ayan.spring.webapp.repositories.RecipeRepository;
import com.ayan.spring.webapp.repositories.UnitofMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitofMeasureRepository unitofMeasureRepository;
    private final IngredientCommandToIngredient toIngredient;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, UnitofMeasureRepository unitofMeasureRepository, IngredientCommandToIngredient toIngredient) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitofMeasureRepository = unitofMeasureRepository;
        this.toIngredient = toIngredient;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

        if (!recipeOptional.isPresent()) {
            // todo error if not found
            log.error("Recipe Not found for id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {

            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe.getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if (ingredientOptional.isPresent()) {
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUnitOfMeasure(unitofMeasureRepository.findById(command.getUnitOfMeasure()
                        .getId()).orElseThrow(() -> new RuntimeException("UOM Not Found !!")));
            } else {
                // add new ingredient
                recipe.addIngredient(toIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            // todo check for fail
            return ingredientToIngredientCommand.convert(savedRecipe.getIngredients()
                    .stream().filter(recipeIngredient -> recipeIngredient.getId().equals(command.getId()))
                    .findFirst()
                    .get());
        }

    }

}
