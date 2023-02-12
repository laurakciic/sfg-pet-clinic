package com.laurakovacic.sfgpetclinic.repositories;

import com.laurakovacic.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
