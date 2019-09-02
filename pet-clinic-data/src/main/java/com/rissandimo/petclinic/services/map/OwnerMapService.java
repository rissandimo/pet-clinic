package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Owner;
import com.rissandimo.petclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService
        extends AbstractMapService<Owner, Long>
        implements CrudService<Owner, Long>
{
    @Override
    public Set<Owner> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        this.findById(id);
    }

    @Override
    public Owner save(Owner owner)
    {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner)
    {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id)
    {
        return super.findById(id);
    }
}
