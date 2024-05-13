package guruneeraj.springframework.sfgpetclinic.bootstrap;

import guruneeraj.springframework.sfgpetclinic.model.Owner;
import guruneeraj.springframework.sfgpetclinic.model.Vet;
import guruneeraj.springframework.sfgpetclinic.services.VetService;
import guruneeraj.springframework.sfgpetclinic.services.OwnerService;
import guruneeraj.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guruneeraj.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Neeraj");
        owner1.setLastName("Kumar");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Priyanka");
        owner2.setLastName("Kumari");

        ownerService.save(owner2);

        System.out.println("Loaded Owners !!");

        Vet vet1= new Vet();
        vet1.setId(100L);
        vet1.setFirstName("Dr. Anil");
        vet1.setLastName("Kapoor");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(200L);
        vet2.setFirstName("Dr. Ritesh");
        vet2.setLastName("Deshmukh");

        vetService.save(vet2);
        System.out.println("Vet Details Uploaded !!");

    }
}
