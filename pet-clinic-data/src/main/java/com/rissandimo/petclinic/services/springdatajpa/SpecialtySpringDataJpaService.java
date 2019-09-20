package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.Specialty;
import com.rissandimo.petclinic.repositories.SpecialtyRepository;
import com.rissandimo.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class SpecialtySpringDataJpaService implements SpecialtiesService
{
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySpringDataJpaService(SpecialtyRepository specialtyRepository)
    {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll()
    {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id)
    {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty specialty)
    {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty)
    {
        specialtyRepository.delete(specialty);
    }

    @Override
    public void deleteById(Long id)
    {
        specialtyRepository.deleteById(id);
    }
}
