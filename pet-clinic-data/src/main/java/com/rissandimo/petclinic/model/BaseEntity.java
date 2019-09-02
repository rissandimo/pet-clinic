package com.rissandimo.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable
{
    //hibernate suggets to use Long - b/c can be null, primitives can't
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
