package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
