package com.laurakovacic.sfgpetclinic.bootstrap;

import com.laurakovacic.sfgpetclinic.model.Owner;
import com.laurakovacic.sfgpetclinic.model.Vet;
import com.laurakovacic.sfgpetclinic.services.OwnerService;
import com.laurakovacic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Laura");
        owner1.setLastName("Kovacic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Luka");
        owner2.setLastName("Ronin");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Domagoj");
        vet1.setLastName("Petrovic");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Borna");
        vet2.setLastName("Simunovic");

        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
