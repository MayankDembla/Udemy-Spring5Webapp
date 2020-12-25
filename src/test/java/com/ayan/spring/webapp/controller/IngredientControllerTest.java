package com.ayan.spring.webapp.controller;

import com.ayan.spring.webapp.commands.IngredientCommand;
import com.ayan.spring.webapp.commands.RecipeCommand;
import com.ayan.spring.webapp.services.IngredientService;
import com.ayan.spring.webapp.services.RecipeService;
import com.ayan.spring.webapp.services.UnitOfMeasureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IngredientControllerTest {

    @Mock
    public RecipeService recipeService;

    @Mock
    public IngredientService ingredientService;

    @Mock
    public UnitOfMeasureService unitOfMeasureService;

    public IngredientController ingredientController;
    public MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientController = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    public void testListIngredients() throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        //when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        //then
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void testShowIngredients() throws Exception {

        // given
        IngredientCommand ingredientCommand = new IngredientCommand();

        // when
        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);

        // then
        mockMvc.perform(get("/recipe/1/ingredient/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show"))
                .andExpect(model().attributeExists("ingredient"));

    }


    @Test
    public void testupdateRecipeIngredient() throws Exception {

        IngredientCommand command = new IngredientCommand();
        command.setId(2L);
        command.setRecipeId(3L);

        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong()))
                .thenReturn(command);


        mockMvc.perform(get("/recipe/3/ingredient/2/update"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"))
                .andExpect(view().name("recipe/ingredient/ingredientform"));

    }

    @Test
    public void testsaveOrUpdate() throws Exception {

        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);


        //when
        when(ingredientService.saveIngredientCommand(any(IngredientCommand.class))).thenReturn(command);

        // when
        mockMvc.perform(post("/recipe/2/ingredient")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredient/3/show"));


    }
}