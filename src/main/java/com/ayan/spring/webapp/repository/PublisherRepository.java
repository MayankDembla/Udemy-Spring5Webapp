package com.ayan.spring.webapp.repository;

import com.ayan.spring.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
