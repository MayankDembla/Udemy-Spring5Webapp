package com.ayan.spring.webapp.bootstrap;

import com.ayan.spring.webapp.model.Owner;
import com.ayan.spring.webapp.model.PetType;
import com.ayan.spring.webapp.model.Vet;
import com.ayan.spring.webapp.services.PetTypeService;
import com.ayan.spring.webapp.services.map.OwnerMapService;
import com.ayan.spring.webapp.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerMapService ownerService;
    private final VetMapService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerMapService ownerService, VetMapService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadOwners();
        loadVets();
        loadPetType();
    }

    private void loadOwners() {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mayank");
        owner1.setLastName("Dembla");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jatin");
        owner2.setLastName("Dembla");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");
    }

    private void loadVets() {

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets ... ");

    }

    private void loadPetType() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetType ... ");

    }


}
