package com.laurakovacic.sfgpetclinic.services;

import com.laurakovacic.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
