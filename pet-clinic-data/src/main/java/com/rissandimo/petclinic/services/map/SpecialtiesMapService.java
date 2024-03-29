package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Specialty;
import com.rissandimo.petclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"default", "map"})
@Service
public class SpecialtiesMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService
{
    @Override
    public Set<Specialty> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty)
    {
        super.delete(specialty);
    }

    @Override
    public Specialty save(Specialty specialty)
    {
        return super.save(specialty);
    }

    @Override
    public Specialty findById(Long id)
    {
        return super.findById(id);
    }
}
