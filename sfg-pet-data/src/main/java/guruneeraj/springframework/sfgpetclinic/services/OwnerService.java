package guruneeraj.springframework.sfgpetclinic.services;

import guruneeraj.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);


}
