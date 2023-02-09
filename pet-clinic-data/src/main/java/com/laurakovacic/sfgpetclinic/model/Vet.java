package com.laurakovacic.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    private Set<Specialty> specialties = new HashSet<>();   // good practice to initialize with default value so the exception is not thrown when adding values

    public Set<Specialty> getSpecialties() {                // this would throw an exception if specialties wasn't initialized
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
