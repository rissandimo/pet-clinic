package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.PetType;
import com.rissandimo.petclinic.repositories.PetTypeRepository;
import com.rissandimo.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class PetTypeSpringDataJpaService implements PetTypeService
{
    private final PetTypeRepository petTypeRepository;

    public PetTypeSpringDataJpaService(PetTypeRepository petTypeRepository)
    {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll()
    {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id)
    {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType)
    {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType)
    {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id)
    {
        petTypeRepository.deleteById(id);
    }
}
