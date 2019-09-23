package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Specialty;
import com.rissandimo.petclinic.model.Vet;
import com.rissandimo.petclinic.services.SpecialtiesService;
import com.rissandimo.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Profile({"default", "map"})
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService
{

    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService)
    {
        this.specialtiesService = specialtiesService;
    }

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
    public Vet save(Vet vet)
    {
        if(vet.getSpecialties().size() > 0)
        {
            vet.getSpecialties().forEach(specialty ->
            {
                if(specialty.getId() == null) // assign ID to specialty if it has none - precaution
                {
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(vet);
    }

    @Override
    public Vet findById(Long id)
    {
        return super.findById(id);
    }
}
