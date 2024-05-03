package guruneeraj.springframework.sfgpetclinic.services;
import guruneeraj.springframework.sfgpetclinic.model.Pet;
import java.util.Set;

public interface PetService {

    Set<Pet> findAll();

    Pet findById(Long id);

    Pet save(Pet pet);
}
