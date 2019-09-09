package com.rissandimo.petclinic.bootstrap;

import com.rissandimo.petclinic.model.*;
import com.rissandimo.petclinic.services.OwnerService;
import com.rissandimo.petclinic.services.PetTypeService;
import com.rissandimo.petclinic.services.SpecialtiesService;
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
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtiesService specialtiesService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
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
        int numOfPets = petTypeService.findAll().size();

        if(numOfPets == 0)
        {
            loadData();
        }
    }

    private void loadData()
    {
        //Create dog pet type
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedPetDogType = petTypeService.save(petTypeDog);

        //Create cat pet type
        PetType petTypeCat = new PetType();
        petTypeDog.setName("Cat");
        PetType savedPetCatType = petTypeService.save(petTypeCat);

        //Create Specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);


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

        //Create owner - Fionna
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
        ownerService.save(owner2Fionna);

        System.out.println("Loaded owners...");

        //Create vet 1
        Vet vet1Sam = new Vet();
        vet1Sam.setFirstName("Sam");
        vet1Sam.setLastName("Axe");
        vet1Sam.getSpecialties().add(savedRadiology);

        vetService.save(vet1Sam);

        //Create vet 2
        Vet vet2Jessie = new Vet();
        vet2Jessie.setFirstName("Jessie");
        vet2Jessie.setLastName("Porter");
        vet2Jessie.getSpecialties().add(savedSurgery);

        vetService.save(vet2Jessie);

        System.out.println("Loaded vets....");
    }
}
