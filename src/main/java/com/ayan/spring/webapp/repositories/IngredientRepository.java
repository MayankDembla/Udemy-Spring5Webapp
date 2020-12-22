package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
