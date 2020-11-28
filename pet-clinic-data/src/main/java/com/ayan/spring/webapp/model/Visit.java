package com.ayan.spring.webapp.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Visit extends BaseEntity {

    private LocalDate localDate;
    private String description;
    private Pet pet;

}