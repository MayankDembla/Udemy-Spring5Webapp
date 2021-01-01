package com.ayan.spring.webapp.services.map;

import com.ayan.spring.webapp.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PetMapServiceTest {

    private final long petId = 1L;
    private PetMapService petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {

        Set<Pet> petSet = petMapService.findAll();
        assertEquals(1, petSet.size());

    }

    @Test
    void deleteByIdCorrectId() {

        petMapService.deleteById(petId);

        assertEquals(0, petMapService.findAll().size());
    }


    @Test
    void deleteByIdNullId() {
        petMapService.deleteById(null);
        assertEquals(1, petMapService.findAll().size());
    }

    @Test
    void save() {

        petMapService.save(Pet.builder().id(2L).build());
        assertEquals(2, petMapService.findAll().size());

    }

    @Test
    void findById() {

        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());

    }

    @Test
    void findByIdNotExixting() {
        Pet pet = petMapService.findById(3L);
        assertNull(pet);
    }
}