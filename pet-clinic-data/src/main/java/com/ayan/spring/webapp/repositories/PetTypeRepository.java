package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
