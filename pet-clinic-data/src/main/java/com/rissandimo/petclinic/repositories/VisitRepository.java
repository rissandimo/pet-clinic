package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long>
{
}
