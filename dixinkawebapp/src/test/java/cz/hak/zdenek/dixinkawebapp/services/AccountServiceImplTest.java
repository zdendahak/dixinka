package cz.hak.zdenek.dixinkawebapp.services;

import cz.hak.zdenek.dixinkawebapp.DixinkawebappApplication;
import cz.hak.zdenek.dixinkawebapp.api.v1.mapper.AccountMapper;
import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.domain.Account;
import cz.hak.zdenek.dixinkawebapp.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    public static final String NAME_1 = "My Name 1";
    public static final String SURNAME_1 = "My Surname 1";
    public static final long ID_1 = 1L;
    public static final String NAME_2 = "My Name 2";
    public static final String SURNAME_2 = "My Surname 2";
    public static final long ID_2 = 1L;

    AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        accountService = new AccountServiceImpl(accountRepository, accountMapper);
    }

    @Test
    public void getAllAccounts(){
        Account account = new Account();
        account.setName(NAME_1);
        account.setSurname(SURNAME_1);
        account.setId(ID_1);

        Account account2 = new Account();
        account2.setName(NAME_2);
        account2.setSurname(SURNAME_2);
        account2.setId(ID_2);

        //given
        when(accountRepository.findAll()).thenReturn(Arrays.asList(account, account2));

        //when
        List<AccountDTO> accountDTOS = accountService.getAllAccounts();

        //then
        assertEquals(2, accountDTOS.size());
    }

    @Test
    public void getAccountById() throws Exception {
        //given
        Account account1 = new Account();
        account1.setId(ID_1);
        account1.setName(NAME_1);
        account1.setSurname(SURNAME_1);

        when(accountRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(account1));

        //when
        AccountDTO accountDTO = accountService.getAccountById(ID_1);

        assertEquals(NAME_1, accountDTO.getName());
        assertEquals(SURNAME_1, accountDTO.getSurname());
    }

    private Account getAccount1() {
        Account account = new Account();
        account.setName(NAME_1);
        account.setSurname(SURNAME_1);
        account.setId(ID_1);
        return account;
    }

    private Account getAccount2() {
        Account account = new Account();
        account.setName(NAME_2);
        account.setSurname(SURNAME_2);
        account.setId(ID_2);
        return account;
    }
}
