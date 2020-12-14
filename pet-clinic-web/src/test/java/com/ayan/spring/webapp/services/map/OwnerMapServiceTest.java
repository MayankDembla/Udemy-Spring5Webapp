package com.ayan.spring.webapp.services.map;

import com.ayan.spring.webapp.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerID = 1L;
    final String lastname = "Dembla";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerID).lastName(lastname).build());
    }

    @Test
    void findById() {
        Owner byId = ownerMapService.findById(ownerID);

        assertEquals(1, byId.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(ownerID));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistId() {

        Long id = 2L;
        Owner save = ownerMapService.save(Owner.builder().id(id).build());

        assertEquals(id, save.getId());

    }

    @Test
    void saveNoId() {

        Owner save = ownerMapService.save(Owner.builder().build());
        assertNotNull(save);
        assertNotNull(save.getId());
    }

    @Test
    void findAll() {

        Set<Owner> ownerset = ownerMapService.findAll();
        assertEquals(1, ownerset.size());
    }

    @Test
    void findByLastName() {
        Owner byLastName = ownerMapService.findByLastName(lastname);

        assertNotNull(byLastName);
        assertEquals(ownerID, byLastName.getId());
    }

    @Test
    void findbyLastNameNoRecord() {

        Owner byLastName = ownerMapService.findByLastName("lastname");
        assertNull(byLastName);
    }

    @Test
    void findAllByLastName() {

        ownerMapService.save(Owner.builder().id(2L).lastName(lastname).build());

        Set<Owner> allByLastName = ownerMapService.findAllByLastName(lastname);
        assertEquals(2, allByLastName.size());

    }
}