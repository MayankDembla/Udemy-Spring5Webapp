package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
