package guruneeraj.springframework.sfgpetclinic.services;

import guruneeraj.springframework.sfgpetclinic.model.Owner;
import java.util.Set;

public interface OwnerService {

    Set<Owner> findAll();

    Owner findById(Long id);

    Owner save(Owner owner);

    Owner findByLastName(String lastName);


}
