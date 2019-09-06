package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.BaseEntity;

import java.util.*;

abstract class AbstractMapService<T extends BaseEntity, ID extends Long>
{
    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll()
    {
        return new HashSet<>(map.values());
    }

    T findById(ID id)
    {
        return map.get(id);
    }

    T save(T object)
    {
        //check of object exists
        if(object != null)
        {
            if(object.getId() == null)
            {
                object.setId(getNextId());   //set id
            }
            map.put(object.getId(), object);
        }
        else
        {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id)
    {
        map.remove(id);
    }

    /**
     *within this map - if a certain key's value(object) == object parameter -> remove it from map
     * @param object to be compared against every entry in map
     */
    void delete(T object)
    {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId()
    {
        Long nextId;

        try
        {
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch(NoSuchElementException e)
        {
            nextId = 1L;
        }
        return nextId;
    }
}
