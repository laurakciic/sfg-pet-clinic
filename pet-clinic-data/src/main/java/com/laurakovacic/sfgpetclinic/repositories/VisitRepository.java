package com.laurakovacic.sfgpetclinic.repositories;

import com.laurakovacic.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
