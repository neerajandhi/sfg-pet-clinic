package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.Speciality;
import guruneeraj.springframework.sfgpetclinic.services.SpecialityService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
    /**
     * @return
     */
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    /**
     * @param t
     */
    @Override
    public void delete(Speciality t) {
        super.delete(t);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    /**
     * @param t
     * @return
     */
    @Override
    public Speciality save(Speciality t) {
        return super.save(t);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
