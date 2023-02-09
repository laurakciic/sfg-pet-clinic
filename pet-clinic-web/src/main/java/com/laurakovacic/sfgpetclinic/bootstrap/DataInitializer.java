package com.laurakovacic.sfgpetclinic.bootstrap;

import com.laurakovacic.sfgpetclinic.model.Owner;
import com.laurakovacic.sfgpetclinic.model.Pet;
import com.laurakovacic.sfgpetclinic.model.PetType;
import com.laurakovacic.sfgpetclinic.model.Vet;
import com.laurakovacic.sfgpetclinic.services.OwnerService;
import com.laurakovacic.sfgpetclinic.services.PetTypeService;
import com.laurakovacic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Doggo");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Freya");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Laura");
        owner1.setLastName("Kovacic");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Luka");
        owner2.setLastName("Ronin");

        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Domagoj");
        vet1.setLastName("Petrovic");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Borna");
        vet2.setLastName("Simunovic");

        vetService.save(vet2);
        System.out.println("Loaded vets...");
    }
}
