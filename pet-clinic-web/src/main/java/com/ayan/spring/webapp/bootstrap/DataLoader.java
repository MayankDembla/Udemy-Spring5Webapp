package com.ayan.spring.webapp.bootstrap;

import com.ayan.spring.webapp.model.Owner;
import com.ayan.spring.webapp.model.Vet;
import com.ayan.spring.webapp.services.map.OwnerMapService;
import com.ayan.spring.webapp.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerMapService ownerService;
    private final VetMapService vetService;

    public DataLoader(OwnerMapService ownerService, VetMapService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mayank");
        owner1.setLastName("Dembla");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jatin");
        owner2.setLastName("Dembla");

        ownerService.save(owner2);

        System.out.println("Loaded Orders....");

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


}
