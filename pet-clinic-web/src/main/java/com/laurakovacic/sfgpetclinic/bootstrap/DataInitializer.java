package com.laurakovacic.sfgpetclinic.bootstrap;

import com.laurakovacic.sfgpetclinic.model.*;
import com.laurakovacic.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);       // we get ID value when we persist to the map

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = Owner.builder()
                .firstName("Laura")
                .lastName("Kovacic")
                .address("12A Bickerer")
                .city("Miami")
                .telephone("12332189732")
                .build();
        ownerService.save(owner1);

        Pet laurasPet = Pet.builder()
                .owner(owner1)
                .petType(savedDogPetType)
                .birthDate(LocalDate.now())
                .name("Buck")
                .build();

        owner1.getPets().add(laurasPet);
        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Luka")
                .lastName("Roncevic")
                .address("12A Bickerer")
                .city("Miami")
                .telephone("314313132")
                .build();
        ownerService.save(owner2);

        Pet lukasPet = Pet.builder()
                .owner(owner2)
                .petType(savedCatPetType)
                .birthDate(LocalDate.now())
                .name("Zujka")
                .build();

        owner2.getPets().add(lukasPet);
        ownerService.save(owner2);

        Visit catVisit = Visit.builder()
                .pet(lukasPet)
                .date(LocalDate.now())
                .description("Regular check")
                .build();
        visitService.save(catVisit);

        Visit dogVisit = Visit.builder()
                .pet(laurasPet)
                .date(LocalDate.now())
                .description("Postop check")
                .build();
        visitService.save(dogVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = Vet.builder()
                .firstName("Domagoj")
                .lastName("Petrovic")
                .specialties(Collections.singleton(savedRadiology))
                .build();
        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Borna")
                .lastName("Simunovic")
                .specialties(Collections.singleton(savedSurgery))
                .build();
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
