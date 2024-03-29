package com.rissandimo.petclinic.services.springdatajpa;

import com.rissandimo.petclinic.model.Visit;
import com.rissandimo.petclinic.repositories.VisitRepository;
import com.rissandimo.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
@Service
public class VisitSpringDataJpaService implements VisitService
{
    private final VisitRepository visitRepository;

    public VisitSpringDataJpaService(VisitRepository visitRepository)
    {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll()
    {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id)
    {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit)
    {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit)
    {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id)
    {
        visitRepository.deleteById(id);
    }
}
