package com.rissandimo.petclinic.bootstrap;

import com.rissandimo.petclinic.model.Owner;
import com.rissandimo.petclinic.model.PetType;
import com.rissandimo.petclinic.model.Vet;
import com.rissandimo.petclinic.services.OwnerService;
import com.rissandimo.petclinic.services.PetTypeService;
import com.rissandimo.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception
    {

        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedPetDogType = petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeDog.setName("Cat");
        PetType savedPetCatType = petTypeService.save(petTypeCat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenneane");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
