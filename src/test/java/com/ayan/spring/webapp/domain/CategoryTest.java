package com.ayan.spring.webapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long iDValue = 4L;
        category.setId(4L);
        assertEquals(iDValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}