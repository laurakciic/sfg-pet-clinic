package com.laurakovacic.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)                    // JPA will try load all at once
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))   // table with IDs from both sides of the relationship
    private Set<Specialty> specialties = new HashSet<>();
}
