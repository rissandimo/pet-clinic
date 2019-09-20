package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>
{
}
