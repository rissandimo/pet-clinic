package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.Vet;
import com.rissandimo.petclinic.repositories.VetRepository;
import com.rissandimo.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class VetSpringDataJpaService implements VetService
{
    private final VetRepository vetRepository;

    public VetSpringDataJpaService(VetRepository vetRepository)
    {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll()
    {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id)
    {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet)
    {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet)
    {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id)
    {
        vetRepository.deleteById(id);
    }
}
