package elixr.springframework.sfgpetclinic.services.map;

import elixr.springframework.sfgpetclinic.model.Owner;
import elixr.springframework.sfgpetclinic.model.Pet;
import elixr.springframework.sfgpetclinic.model.PetType;
import elixr.springframework.sfgpetclinic.services.OwnerService;
import elixr.springframework.sfgpetclinic.services.PetService;
import elixr.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwenerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwenerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet ->
                {  if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            PetType savedPetType = petTypeService.save(pet.getPetType());
                            pet.setPetType(savedPetType);
                        }
                    }
                   else{
                      throw new RuntimeException("Pet Type is required");
                    }
                   if(pet.getId() == null){
                       Pet savedPet = petService.save(pet);
                       pet.setId(savedPet.getId());
                   }
                });
            }
            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
