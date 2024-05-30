package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.Owner;
import guruneeraj.springframework.sfgpetclinic.model.Pet;
import guruneeraj.springframework.sfgpetclinic.services.OwnerService;
import guruneeraj.springframework.sfgpetclinic.services.PetService;
import guruneeraj.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner entry) {
        if(entry != null){
            if (entry.getPets() != null && !entry.getPets().isEmpty()) {
                entry.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(entry);
        } else {
            return null;
        }

    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
