package com.rissandimo.petclinic.bootstrap;

import com.rissandimo.petclinic.model.Owner;
import com.rissandimo.petclinic.model.Pet;
import com.rissandimo.petclinic.model.PetType;
import com.rissandimo.petclinic.model.Vet;
import com.rissandimo.petclinic.services.OwnerService;
import com.rissandimo.petclinic.services.PetTypeService;
import com.rissandimo.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

    /**
     * Create an owner, a pet for the owner - bind pet to owner - persist owner
     * Create an owner2, a pet for the owner2 - bind pet to owner2 - persist owner2
     * @param args not used
     * @throws Exception not necessary
     */
    @Override
    public void run(String... args) throws Exception
    {

        //create dog pet type
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedPetDogType = petTypeService.save(petTypeDog);

        //create cat pet type
        PetType petTypeCat = new PetType();
        petTypeDog.setName("Cat");
        PetType savedPetCatType = petTypeService.save(petTypeCat);


        //Create owner - michael
        Owner owner1Michael = new Owner();
        owner1Michael.setFirstName("Michael");
        owner1Michael.setLastName("Weston");
        owner1Michael.setAddress("123 Brickerel");
        owner1Michael.setCity("Miami");
        owner1Michael.setTelephone("123456789");

        //Create michael's pet - then bind it to Michael
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedPetDogType);
        mikesPet.setOwner(owner1Michael);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Roscow");
        owner1Michael.getPets().add(mikesPet);
        ownerService.save(owner1Michael);

/*        //Create owner - Fionna
        Owner owner2Fionna = new Owner();
        owner2Fionna.setFirstName("Fionna");
        owner2Fionna.setLastName("Glenneane");
        owner1Michael.setAddress("123 Brickerel");
        owner1Michael.setCity("Miami");
        owner1Michael.setTelephone("123456789");

        //Create fionna's pet - then bind it to Fionna
        Pet fionnasPet = new Pet();
        fionnasPet.setPetType(savedPetCatType);
        fionnasPet.setOwner(owner2Fionna);
        fionnasPet.setBirthDate(LocalDate.now());
        fionnasPet.setName("Giner");
        owner2Fionna.getPets().add(fionnasPet);
        ownerService.save(owner2Fionna);*/

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
