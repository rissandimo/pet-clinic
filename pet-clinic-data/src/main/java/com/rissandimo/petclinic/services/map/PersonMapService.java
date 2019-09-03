package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Person;
import com.rissandimo.petclinic.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonMapService
        extends AbstractMapService<Person, Long>
        implements CrudService<Person, Long>
{

    @Override
    public Set<Person> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Person person)
    {
        super.delete(person);
    }

    @Override
    public Person save(Person person)
    {
        return super.save(person);
    }

    @Override
    public Person findById(Long id)
    {
        return super.findById(id);
    }
}
