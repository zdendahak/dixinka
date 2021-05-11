package cz.hak.zdenek.dixinkawebapp.bootstrap;

import cz.hak.zdenek.dixinkawebapp.domain.Account;
import cz.hak.zdenek.dixinkawebapp.domain.AnimalType;
import cz.hak.zdenek.dixinkawebapp.repositories.AccountRepository;
import cz.hak.zdenek.dixinkawebapp.repositories.AnimalTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AnimalTypeRepository animalTypeRepository;

    public Bootstrap(AccountRepository accountRepository, AnimalTypeRepository animalTypeRepository) {
        this.accountRepository = accountRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadAccounts();
        loadAnimalType();
    }



    private void loadAccounts() {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setName("Adele");
        account1.setSurname("A");

        Account account2 = new Account();
        account2.setId(2L);
        account2.setName("Bob");
        account2.setSurname("M");

        accountRepository.save(account1);
        accountRepository.save(account2);

        System.out.println("Account Loaded: " + accountRepository.count());
    }

    private void loadAnimalType() {
        AnimalType animalType1 = new AnimalType();
        animalType1.setId(1L);
        animalType1.setName("Dog");

        AnimalType animalType2 = new AnimalType();
        animalType2.setId(2L);
        animalType2.setName("Fish");

        animalTypeRepository.save(animalType1);
        animalTypeRepository.save(animalType2);

        System.out.println("AnimalType Loaded: " + accountRepository.count());
    }
}
