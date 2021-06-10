package cz.hak.zdenek.dixinkawebapp.controllers.v1;

import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountDTO;
import cz.hak.zdenek.dixinkawebapp.api.v1.model.AccountListDTO;
import cz.hak.zdenek.dixinkawebapp.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AccountController.BASE_URL)
public class AccountController {

    public static final String BASE_URL = "/api/v1/accounts";

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AccountListDTO getAllAccounts(){
        return new AccountListDTO(accountService.getAllAccounts());
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createNewAccount(@RequestBody AccountDTO accountDTO){
        return accountService.createNewAccount(accountDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO){
        return accountService.saveAccountByDTO(id, accountDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO patchAccount(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return accountService.patchAccount(id, customerDTO);
    }


}
