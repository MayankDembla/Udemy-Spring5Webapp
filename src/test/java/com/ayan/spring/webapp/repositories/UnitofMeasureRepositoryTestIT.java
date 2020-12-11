package com.ayan.spring.webapp.repositories;

import com.ayan.spring.webapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitofMeasureRepositoryTestIT {

    @Autowired
    UnitofMeasureRepository unitofMeasureRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @DirtiesContext
    public void findByDescription() {

        Optional<UnitOfMeasure> ofMeasure = unitofMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", ofMeasure.get().getDescription());

    }

    @Test
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> ofMeasure = unitofMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", ofMeasure.get().getDescription());

    }

}