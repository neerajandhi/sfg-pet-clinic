package guruneeraj.springframework.sfgpetclinic.bootstrap;

import guruneeraj.springframework.sfgpetclinic.model.*;
import guruneeraj.springframework.sfgpetclinic.services.PetTypeService;
import guruneeraj.springframework.sfgpetclinic.services.SpecialityService;
import guruneeraj.springframework.sfgpetclinic.services.VetService;
import guruneeraj.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().isEmpty()){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =  petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Neeraj");
        owner1.setLastName("Kumar");
        owner1.setAddress("303 Block A");
        owner1.setCity("Patna");
        owner1.setTelephone("5555555555");

        Pet NeerajKaKutta = new Pet();
        NeerajKaKutta.setName("Cafe");
        NeerajKaKutta.setPetType(savedDogPetType);
        NeerajKaKutta.setOwner(owner1);
        NeerajKaKutta.setBirthDate(LocalDate.now());

        owner1.getPets().add(NeerajKaKutta);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Priyanka");
        owner2.setLastName("Kumari");
        owner2.setAddress("206 Block B");
        owner2.setCity("Bengaluru");
        owner2.setTelephone("112211221122");

        Pet PriyankiBilli = new Pet();
        PriyankiBilli.setName("Khushi");
        PriyankiBilli.setPetType(savedCatPetType);
        PriyankiBilli.setOwner(owner2);
        PriyankiBilli.setBirthDate(LocalDate.now());
        owner2.getPets().add(PriyankiBilli);
        ownerService.save(owner2);

        System.out.println("Loaded Owners !!");

        Vet vet1= new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Dr. Anil");
        vet1.setLastName("Kapoor");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Dr. Ritesh");
        vet2.setLastName("Deshmukh");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);
        System.out.println("Vet Details Uploaded !!");

        System.out.println("What is the size of ownerService:" + ownerService.findAll().size());

        System.out.println("What is the size of vetService:" + vetService.findAll().size());
    }
}
