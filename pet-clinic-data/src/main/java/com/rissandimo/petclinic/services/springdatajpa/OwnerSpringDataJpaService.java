package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.Owner;
import com.rissandimo.petclinic.repositories.OwnerRepository;
import com.rissandimo.petclinic.repositories.PetRepository;
import com.rissandimo.petclinic.repositories.PetTypeRepository;
import com.rissandimo.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class OwnerSpringDataJpaService implements OwnerService
{

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSpringDataJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
                                     PetTypeRepository petTypeRepository)
    {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName)
    {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll()
    {
        Set<Owner> ownersList = new HashSet<>();
        ownerRepository.findAll().forEach(ownersList::add);
        return ownersList;
    }

    @Override
    public Owner findById(Long id)
    {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner)
    {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner)
    {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id)
    {
        ownerRepository.deleteById(id);
    }
}
