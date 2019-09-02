package com.rissandimo.petclinic.services;

import com.rissandimo.petclinic.model.Vet;

import java.util.Set;

public interface VetService
{
    Vet findById(Long id);

    Vet saveVet(Vet vet);

    Set<Vet> findAll();
}
