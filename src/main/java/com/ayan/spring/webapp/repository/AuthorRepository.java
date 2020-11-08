package com.ayan.spring.webapp.repository;

import com.ayan.spring.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
