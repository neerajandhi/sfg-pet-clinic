package guruneeraj.springframework.sfgpetclinic.bootstrap;

import guruneeraj.springframework.sfgpetclinic.model.Owner;
import guruneeraj.springframework.sfgpetclinic.model.PetType;
import guruneeraj.springframework.sfgpetclinic.model.Vet;
import guruneeraj.springframework.sfgpetclinic.services.PetTypeService;
import guruneeraj.springframework.sfgpetclinic.services.VetService;
import guruneeraj.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =  petTypeService.save(cat);


        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Neeraj");
        owner1.setLastName("Kumar");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Priyanka");
        owner2.setLastName("Kumari");

        ownerService.save(owner2);

        System.out.println("Loaded Owners !!");

        Vet vet1= new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Dr. Anil");
        vet1.setLastName("Kapoor");

        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Dr. Ritesh");
        vet2.setLastName("Deshmukh");

        vetService.save(vet2);
        System.out.println("Vet Details Uploaded !!");

        System.out.println("What is the size of ownerService:" + ownerService.findAll().size());

        System.out.println("What is the size of vetService:" + vetService.findAll().size());

    }
}
