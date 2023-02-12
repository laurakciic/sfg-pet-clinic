package com.laurakovacic.sfgpetclinic.repositories;

import com.laurakovacic.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
