package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.Vet;
import guruneeraj.springframework.sfgpetclinic.services.CrudService;
import guruneeraj.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Vet t) {

    }

    @Override
    public Vet save(Vet vet) {
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return null;
    }
}
