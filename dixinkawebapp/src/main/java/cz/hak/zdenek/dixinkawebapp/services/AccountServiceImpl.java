package cz.hak.zdenek.dixinkawebapp.services;

import cz.hak.zdenek.dixinkawebapp.api.v1.mapper.AccountMapper;
import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.domain.Account;
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

    @Override
    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::accountToAccountDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AccountDTO createNewAccount(AccountDTO accountDTO) {
        return saveAndReturnDTO(accountMapper.accountDtoToAccount(accountDTO));
    }

    @Override
    public AccountDTO saveAccountByDTO(Long id, AccountDTO accountDTO) {
        Account account = accountMapper.accountDtoToAccount(accountDTO);
        account.setId(id);

        return saveAndReturnDTO(account) ;
    }

    @Override
    public AccountDTO patchAccount(Long id, AccountDTO accountDTO) {
        return accountRepository.findById(id).map(account -> {

            if(accountDTO.getName() != null){
                account.setName(accountDTO.getName());
            }

            if(accountDTO.getSurname() != null){
                account.setName(accountDTO.getSurname());
            }

            AccountDTO returnDto = accountMapper.accountToAccountDTO(accountRepository.save(account));


            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    private AccountDTO saveAndReturnDTO(Account account) {
        Account savedAccount = accountRepository.save(account);

        AccountDTO returnDto = accountMapper.accountToAccountDTO(savedAccount);

        return returnDto;
    }
}
