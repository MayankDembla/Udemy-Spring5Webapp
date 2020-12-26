package com.ayan.spring.webapp.services.springdatajpa;

import com.ayan.spring.webapp.model.Owner;
import com.ayan.spring.webapp.repositories.OwnerRepository;
import com.ayan.spring.webapp.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@Profile("springdatajpa")
public class OwnersJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnersJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> byId = ownerRepository.findById(aLong);
        return byId.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAllByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        log.debug("Find Owner " + ownerRepository.findAllByLastNameLike(lastName));
        return ownerRepository.findAllByLastNameLike(lastName);
    }
}
