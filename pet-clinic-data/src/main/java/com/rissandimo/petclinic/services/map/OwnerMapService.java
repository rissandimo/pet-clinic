package com.rissandimo.petclinic.services.map;

import com.rissandimo.petclinic.model.Owner;
import com.rissandimo.petclinic.model.Pet;
import com.rissandimo.petclinic.services.OwnerService;
import com.rissandimo.petclinic.services.PetService;
import com.rissandimo.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService
{

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService)
    {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
    public Owner save(Owner owner) {

        if(owner != null){ // owner already exists
            if (owner.getPets() != null) { // owner has pets
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){ // pet type not saved
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));// persist pet type w/ id, then apply it to pojo
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){// check if pet has not been saved - extra safe check
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);

        } else {
            return null;
        }
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

    @Override
    public Owner findByLastName(String lastName)
    {
        return null;
    }
}
