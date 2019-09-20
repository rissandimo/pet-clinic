package com.rissandimo.petclinic.repositories;

import com.rissandimo.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long>
{
}
