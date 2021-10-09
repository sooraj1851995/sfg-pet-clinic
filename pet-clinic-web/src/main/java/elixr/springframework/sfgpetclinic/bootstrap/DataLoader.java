package elixr.springframework.sfgpetclinic.bootstrap;

import elixr.springframework.sfgpetclinic.model.Owner;
import elixr.springframework.sfgpetclinic.model.Pet;
import elixr.springframework.sfgpetclinic.model.PetType;
import elixr.springframework.sfgpetclinic.model.Vet;
import elixr.springframework.sfgpetclinic.services.OwnerService;
import elixr.springframework.sfgpetclinic.services.PetTypeService;
import elixr.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types!!!!!!!!!!!!");

        Owner owner1 = new Owner();
        owner1.setFirstName("Ethun");
        owner1.setLastName("Hunt");
        owner1.setAddress("3559 Shinn Street");
        owner1.setCity("Wisconsin");
        owner1.setTelephone("212-730-9004");
        Pet ethunsPet = new Pet();
        ethunsPet.setPetName("Jimmy");
        ethunsPet.setPetType(saveDogPetType);
        ethunsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(ethunsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Julie");
        owner2.setLastName("Hunt");
        owner2.setAddress("3459 Delta Street");
        owner2.setCity("ADELL");
        owner2.setTelephone("715-880-3035");
        Pet juliesPet = new Pet();
        juliesPet.setPetName("Billy");
        juliesPet.setPetType(saveCatPetType);
        juliesPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(juliesPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners!!!!!!!!!!!!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Benchy");
        vet1.setLastName("Michale");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Luther");
        vet2.setLastName("John");
        vetService.save(vet2);

        System.out.println("Loaded Vets!!!!!!!!!!!!");

    }
}
