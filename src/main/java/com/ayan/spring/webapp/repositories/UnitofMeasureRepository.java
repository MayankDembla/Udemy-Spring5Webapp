package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitofMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

   Optional<UnitOfMeasure> findByDescription(String description);
}
