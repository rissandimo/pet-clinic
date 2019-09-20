package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.Pet;
import com.rissandimo.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class PetSpringDataJpa implements PetService
{
    private final PetService petService;

    public PetSpringDataJpa(PetService petService)
    {
        this.petService = petService;
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        petService.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id)
    {
        return petService.findById(id);
    }

    @Override
    public Pet save(Pet pet)
    {
        return petService.save(pet);
    }

    @Override
    public void delete(Pet pet)
    {
        petService.delete(pet);
    }

    @Override
    public void deleteById(Long id)
    {
        petService.deleteById(id);
    }
}
