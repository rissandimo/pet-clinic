package com.rissandimo.petclinic.services;

import com.rissandimo.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>
{
    Owner findByLastName(String lastName);
}
