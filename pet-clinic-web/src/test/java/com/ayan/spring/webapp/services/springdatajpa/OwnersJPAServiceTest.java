package com.ayan.spring.webapp.services.springdatajpa;

import com.ayan.spring.webapp.model.Owner;
import com.ayan.spring.webapp.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnersJPAServiceTest {

    public static final String LAST_NAME = "smith";
    @InjectMocks
    OwnersJPAService ownersJPAService;

    private final Long OWNER_ID = 1L;

    private final Owner returendOwner = Owner.builder().lastName(LAST_NAME).id(OWNER_ID).build();

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        ownersJPAService.save(Owner.builder().lastName(LAST_NAME).id(OWNER_ID).build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).lastName("Dembla").build());
        ownerSet.add(Owner.builder().id(2L).lastName("Kori").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownersJPAService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        Optional<Owner> owner = Optional.of(Owner.builder().id(OWNER_ID).lastName("Kori").build());

        when(ownerRepository.findById(OWNER_ID)).thenReturn(owner);

        Owner byId = ownersJPAService.findById(OWNER_ID);

        assertNotNull(byId);
        assertEquals(OWNER_ID, byId.getId());
        assertEquals("Kori", byId.getLastName());
    }

    @Test
    void findbyIdNotFound() {

        when(ownerRepository.findById(OWNER_ID)).thenReturn(Optional.empty());

        Owner owner = ownersJPAService.findById(1L);

        assertNull(owner);

    }

    @Test
    void save() {

        Owner owner = Owner.builder().id(3L).lastName("Kori").firstName("Nandini").build();

        when(ownerRepository.save(owner)).thenReturn(owner);

        Owner save = ownersJPAService.save(owner);
        assertEquals(3, save.getId());
        assertEquals("Nandini", save.getFirstName());
        assertEquals("Kori", save.getLastName());
    }

    @Test
    void delete() {

        Owner owner = Owner.builder().id(1L).lastName("Jordan").build();
        ownersJPAService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        Owner owner = Owner.builder().id(1L).lastName("Joe").build();
        ownersJPAService.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {

        Owner returnOwner = Owner.builder().id(2L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownersJPAService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
    }

    @Test
    void findAllByLastName() {

        Owner owner1 = Owner.builder().id(2L).lastName("Kori").build();
        Owner owner2 = Owner.builder().id(3L).lastName("Kori").build();

        Set<Owner> owners = new HashSet<>();
        owners.add(owner1);
        owners.add(owner2);

        when(ownerRepository.findAllByLastName("Kori")).thenReturn(owners);

        Set<Owner> allByLastName = ownersJPAService.findAllByLastName("Kori");

        assertEquals(2, allByLastName.size());
    }
}