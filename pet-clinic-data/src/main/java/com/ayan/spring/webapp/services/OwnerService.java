package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    Set<Owner> findAllByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
