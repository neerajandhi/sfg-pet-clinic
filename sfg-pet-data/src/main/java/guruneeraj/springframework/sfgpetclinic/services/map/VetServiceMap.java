package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.Speciality;
import guruneeraj.springframework.sfgpetclinic.model.Vet;
import guruneeraj.springframework.sfgpetclinic.services.SpecialityService;
import guruneeraj.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet t) {
        super.delete(t);
    }

    @Override
    public Vet save(Vet entry) {

       if(!entry.getSpecialities().isEmpty()){
           entry.getSpecialities().forEach(speciality -> {
               if(speciality.getId() == null){
                   Speciality savedSpeciality = specialityService.save(speciality);
                   speciality.setId(savedSpeciality.getId());
               }
           });
       }

        return super.save(entry);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
