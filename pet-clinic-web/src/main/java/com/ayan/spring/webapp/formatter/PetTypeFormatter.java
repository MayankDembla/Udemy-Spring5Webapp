package com.ayan.spring.webapp.formatter;

import com.ayan.spring.webapp.model.PetType;
import com.ayan.spring.webapp.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {

        Collection<PetType> findPetType = petTypeService.findAll();

        for (PetType p : findPetType) {
            if (p.getName().equals(s)) {
                return p;
            }
        }
        throw new ParseException("type not found: " + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
