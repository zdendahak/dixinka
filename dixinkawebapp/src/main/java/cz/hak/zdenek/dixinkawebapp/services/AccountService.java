package cz.hak.zdenek.dixinkawebapp.services;

import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import java.util.List;

public interface AccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Long id);

    AccountDTO createNewAccount(AccountDTO accountDTO);
}
