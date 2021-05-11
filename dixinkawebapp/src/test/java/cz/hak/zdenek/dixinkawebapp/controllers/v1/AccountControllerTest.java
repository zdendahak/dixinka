package cz.hak.zdenek.dixinkawebapp.controllers.v1;

import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.controllers.RestResponseEntityExceptionHandler;
import cz.hak.zdenek.dixinkawebapp.domain.Account;
import cz.hak.zdenek.dixinkawebapp.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountControllerTest {

    public static final String NAME_1 = "Alice";
    public static final String SURNAME_1 = "My Surname 1";
    public static final long ID_1 = 1L;
    public static final String NAME_2 = "Bob";
    public static final String SURNAME_2 = "My Surname 2";
    public static final long ID_2 = 1L;

    @Mock
    AccountService accountService;

    @InjectMocks
    AccountController accountController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(accountController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    public void testListAccounts() throws Exception {
        AccountDTO account1 = new AccountDTO();
        account1.setId(ID_1);
        account1.setName(NAME_1);
        account1.setSurname(SURNAME_1);

        AccountDTO account2 = new AccountDTO();
        account2.setId(ID_2);
        account2.setName(NAME_2);
        account2.setSurname(SURNAME_2);

        List<AccountDTO> accounts = Arrays.asList(account1, account2);

        when(accountService.getAllAccounts()).thenReturn(accounts);

        mockMvc.perform(get(AccountController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accounts", hasSize(2)));
    }

    @Test
    public void testGetAccountById() throws Exception {

        //given
        AccountDTO account1 = new AccountDTO();
        account1.setName("Michale");
        account1.setSurname("Weston");

        when(accountService.getAccountById(anyLong())).thenReturn(account1);

        //when
        mockMvc.perform(get(AccountController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("Michale")));
    }
}
