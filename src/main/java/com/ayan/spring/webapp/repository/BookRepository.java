package com.ayan.spring.webapp.repository;

import com.ayan.spring.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
