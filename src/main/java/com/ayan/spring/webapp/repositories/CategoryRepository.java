package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
