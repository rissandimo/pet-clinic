package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long>
{
}
