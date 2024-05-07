package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.Pet;
import guruneeraj.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {
    @Override
    public Set<Pet> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Pet t) {

    }

    @Override
    public Pet save(Pet pet) {
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }
}
