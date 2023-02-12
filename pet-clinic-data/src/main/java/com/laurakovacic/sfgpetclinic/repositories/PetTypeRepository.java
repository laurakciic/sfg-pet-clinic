package com.laurakovacic.sfgpetclinic.repositories;

import com.laurakovacic.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
