package com.ayan.spring.webapp.services;

import com.ayan.spring.webapp.domain.UnitOfMeasure;
import com.ayan.spring.webapp.repositories.UnitofMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class UnitOfMeasureServiceImplTest {

    @Mock
    UnitofMeasureRepository unitofMeasureRepository;

    UnitOfMeasureService unitOfMeasureService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitofMeasureRepository);
    }

    @Test
    public void listAllUoms() {

        Set<UnitOfMeasure> uoms = new HashSet<>();

        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        uom1.setDescription("Test1");

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        uom2.setDescription("Test2");

        uoms.add(uom1);
        uoms.add(uom2);

        // when
        when(unitofMeasureRepository.findAll()).thenReturn(uoms);

        // check
        assertNotNull(unitOfMeasureService.listAllUoms());
        assertEquals(2, unitOfMeasureService.listAllUoms().size());
    }
}