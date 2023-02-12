package com.laurakovacic.sfgpetclinic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)                    // JPA will try load all at once
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))   // table with IDs from both sides of the relathionship
    private Set<Specialty> specialties = new HashSet<>();   // good practice to initialize with default value so the exception is not thrown when adding values

    public Set<Specialty> getSpecialties() {                // this would throw an exception if specialties wasn't initialized
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
