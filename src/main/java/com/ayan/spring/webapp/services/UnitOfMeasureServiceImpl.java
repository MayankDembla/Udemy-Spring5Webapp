package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.domain.UnitOfMeasure;
import com.ayan.spring.webapp.repositories.UnitofMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitofMeasureRepository unitofMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitofMeasureRepository unitofMeasureRepository) {
        this.unitofMeasureRepository = unitofMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> listAllUoms() {

        Set<UnitOfMeasure> uoms = new HashSet<>();

        unitofMeasureRepository.findAll().iterator().forEachRemaining(uoms::add);

        return uoms;
    }
}
