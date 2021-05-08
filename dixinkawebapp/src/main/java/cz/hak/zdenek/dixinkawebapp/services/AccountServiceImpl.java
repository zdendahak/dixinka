package cz.hak.zdenek.dixinkawebapp.services;

import cz.hak.zdenek.dixinkawebapp.api.v1.mapper.AccountMapper;
import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountMapper accountMapper;

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {

        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::accountToAccountDTO)
                .collect(Collectors.toList());
    }
}
