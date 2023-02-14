package com.laurakovacic.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder=true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    /*
    When Hibernate tries to persist the Visit it cannot find the Pet inside the database, and fails.
    We have to persist the Pet before the Visit, or it will fail.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)   // the Persist action on the Visit is propagated to the Pet object and the error disapperas
    @JoinColumn(name = "pet_id")                // pet_id property on the visits record
    private Pet pet;
}
