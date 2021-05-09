package cz.hak.zdenek.dixinkawebapp.bootstrap;

import cz.hak.zdenek.dixinkawebapp.domain.Account;
import cz.hak.zdenek.dixinkawebapp.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public Bootstrap(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadAccounts();
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

        System.out.println("Categories Loaded: " + accountRepository.count());
    }
}
