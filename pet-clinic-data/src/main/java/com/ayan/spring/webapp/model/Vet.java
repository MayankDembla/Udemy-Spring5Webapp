package com.ayan.spring.webapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Vet vet = (Vet) o;

        return specialities != null ? specialities.equals(vet.specialities) : vet.specialities == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (specialities != null ? specialities.hashCode() : 0);
        return result;
    }
}
