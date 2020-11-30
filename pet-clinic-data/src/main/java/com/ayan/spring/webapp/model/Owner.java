package com.ayan.spring.webapp.model;

import lombok.Data;

import java.util.Set;

@Data
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Owner owner = (Owner) o;

        // check if name is not equal - owner is different.
        if (!super.equals(o)) return false;

        if (address != null ? !address.equals(owner.address) : owner.address != null) return false;
        if (city != null ? !city.equals(owner.city) : owner.city != null) return false;
        if (telephone != null ? !telephone.equals(owner.telephone) : owner.telephone != null) return false;
        return pets != null ? pets.equals(owner.pets) : owner.pets == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (pets != null ? pets.hashCode() : 0);
        return result;
    }
}
