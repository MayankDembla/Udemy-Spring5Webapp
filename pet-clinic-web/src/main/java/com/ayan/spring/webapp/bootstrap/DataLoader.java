package com.ayan.spring.webapp.bootstrap;

import com.ayan.spring.webapp.model.*;
import com.ayan.spring.webapp.services.PetTypeService;
import com.ayan.spring.webapp.services.SpecialityServices;
import com.ayan.spring.webapp.services.map.OwnerMapService;
import com.ayan.spring.webapp.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerMapService ownerService;
    private final VetMapService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityServices specialtyService;

    public DataLoader(OwnerMapService ownerService, VetMapService vetService, PetTypeService petTypeService, SpecialityServices specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadOwners();
        loadspecialityandthenvets();
        loadPetType();
        loadpet();

    }

    Owner owner1 = new Owner();
    Owner owner2 = new Owner();

    private void loadOwners() {

        owner1.setFirstName("Mayank");
        owner1.setLastName("Dembla");
        owner1.setAddress("2b/l, new colony");
        owner1.setCity("Palwal");
        owner1.setTelephone("870871233");
        ownerService.save(owner1);

        owner2.setFirstName("Jatin");
        owner2.setLastName("Dembla");
        owner2.setAddress("2b/l new, new colony");
        owner2.setCity("Gurugram");
        owner2.setTelephone("720617656");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");
    }

    private void loadVets() {

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets ... ");

    }

    PetType saveDogPetType = null;
    PetType saveCatPetType = null;

    private void loadPetType() {

        PetType dog = new PetType();
        dog.setName("Dog");
        saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        saveCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetType ... ");


    }

    public void loadpet() {

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");

        owner1.getPets().add(mikesPet);

        Pet finosCat = new Pet();
        finosCat.setPetType(saveCatPetType);
        finosCat.setOwner(owner2);
        finosCat.setBirthDate(LocalDate.now());
        finosCat.setName("KateUpon");

        owner2.getPets().add(finosCat);

    }

    Speciality savedRadiology = null;
    Speciality savedSurgery = null;
    Speciality savedDentistry = null;

    public void loadSpeciality() {

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        savedDentistry = specialtyService.save(dentistry);

    }

    public void loadspecialityandthenvets() {
        loadSpeciality();
        loadVets();
    }

}
