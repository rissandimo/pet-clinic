package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
}
