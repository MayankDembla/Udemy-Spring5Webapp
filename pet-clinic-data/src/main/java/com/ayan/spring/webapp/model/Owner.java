package com.ayan.spring.webapp.model;

import lombok.Data;

import java.util.Set;

@Data
public class Owner extends Person {

    private Set<Pet> pets;

}
