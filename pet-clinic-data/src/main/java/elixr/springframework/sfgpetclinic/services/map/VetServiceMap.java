package elixr.springframework.sfgpetclinic.services.map;

import elixr.springframework.sfgpetclinic.model.Specialty;
import elixr.springframework.sfgpetclinic.model.Vet;
import elixr.springframework.sfgpetclinic.services.SpecialityService;
import elixr.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

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
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){

            if(object.getSpecialties() !=null){

                object.getSpecialties().forEach(specialty -> {
                    if(specialty.getId() == null){
                        Specialty savedSpeciality = specialityService.save(specialty);
                        specialty.setId(savedSpeciality.getId());
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
    public Vet findById(Long id) {
        return super.findById(id);
    }

}
