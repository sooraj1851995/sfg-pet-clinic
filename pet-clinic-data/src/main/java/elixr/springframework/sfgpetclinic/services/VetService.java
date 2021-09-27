package elixr.springframework.sfgpetclinic.services;

import elixr.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{

    Vet findByLastName(String lastName);
}
