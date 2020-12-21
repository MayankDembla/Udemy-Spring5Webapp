package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.converters.RecipeCommandToRecipe;
import com.ayan.spring.webapp.converters.RecipeToRecipeCommand;
import com.ayan.spring.webapp.domain.Recipe;
import com.ayan.spring.webapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandToRecipe toRecipe;

    @Mock
    RecipeToRecipeCommand toRecipeCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, toRecipe, toRecipeCommand);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeHashSet = new HashSet<>();
        recipeHashSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeHashSet);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void findById() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null Recipe Returned", recipeReturned);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }
}