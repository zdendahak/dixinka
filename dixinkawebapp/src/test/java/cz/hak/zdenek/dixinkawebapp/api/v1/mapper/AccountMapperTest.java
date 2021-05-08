package cz.hak.zdenek.dixinkawebapp.api.v1.mapper;

import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class AccountMapperTest {

    public static final long ID = 1L;
    public static final String NAME = "Zdenda";
    public static final String SURNAME = "Ha";

    AccountMapper accountMapper = AccountMapper.INSTANCE;

    @Test
    public void accountToAccountDTO(){

        //given
        Account account = new Account();
        account.setId(ID);
        account.setName(NAME);
        account.setSurname(SURNAME);

        //when
        AccountDTO accountDTO = accountMapper.accountToAccountDTO(account);

        //then
        assertEquals(Long.valueOf(ID), accountDTO.getId());
    }
}

