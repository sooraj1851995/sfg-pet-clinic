package elixr.springframework.sfgpetclinic.bootstrap;

import elixr.springframework.sfgpetclinic.model.Owner;
import elixr.springframework.sfgpetclinic.model.Vet;
import elixr.springframework.sfgpetclinic.services.OwnerService;
import elixr.springframework.sfgpetclinic.services.VetService;
import elixr.springframework.sfgpetclinic.services.map.OwenerServiceMap;
import elixr.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwenerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ethun");
        owner1.setLastName("Hunt");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Julie");
        owner2.setLastName("Hunt");
        ownerService.save(owner2);

        System.out.println("Loaded Owners!!!!!!!!!!!!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Benchy");
        vet1.setLastName("Michale");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Luther");
        vet2.setLastName("John");
        vetService.save(vet2);

        System.out.println("Loaded Vets!!!!!!!!!!!!");

    }
}
