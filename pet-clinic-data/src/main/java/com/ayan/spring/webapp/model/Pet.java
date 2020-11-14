package com.ayan.spring.webapp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
