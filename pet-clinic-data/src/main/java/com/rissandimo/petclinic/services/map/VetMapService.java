package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Vet;
import com.rissandimo.petclinic.services.CrudService;

import java.util.Set;

public class VetMapService
        extends AbstractMapService<Vet, Long>
        implements CrudService<Vet, Long>
{
    @Override
    public Set<Vet> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet)
    {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet object)
    {
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }
}
