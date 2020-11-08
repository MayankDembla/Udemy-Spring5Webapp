package com.ayan.spring.webapp.repository;

import com.ayan.spring.webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
