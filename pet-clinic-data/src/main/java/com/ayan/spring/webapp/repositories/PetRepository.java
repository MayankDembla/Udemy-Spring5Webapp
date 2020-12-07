package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {


}
