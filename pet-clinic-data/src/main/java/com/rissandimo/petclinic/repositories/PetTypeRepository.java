package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long>
{
}
