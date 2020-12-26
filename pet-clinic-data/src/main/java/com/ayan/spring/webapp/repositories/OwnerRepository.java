package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    Set<Owner> findAllByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
