package guruneeraj.springframework.sfgpetclinic.services;

import guruneeraj.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet save(Vet vet);
}
