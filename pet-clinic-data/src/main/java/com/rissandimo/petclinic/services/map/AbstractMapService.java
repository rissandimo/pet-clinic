package com.rissandimo.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID>
{
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll()
    {
        return new HashSet<>(map.values());
    }

    T findById(ID id)
    {
        return map.get(id);
    }

    T save(ID id, T object)
    {
        return map.put(id, object);
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
}
