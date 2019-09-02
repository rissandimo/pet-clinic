package com.rissandimo.petclinic.services;

import com.rissandimo.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService
{
    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner saveOwner(Owner owner);

    Set<Owner> findAll();
}
