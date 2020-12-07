package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
