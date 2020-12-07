package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
