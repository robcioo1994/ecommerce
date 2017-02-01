package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.AccountDTO;
import com.robert.ecommerce.dto.ChangePasswordDTO;
import com.robert.ecommerce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = POST, path = "api/account/updateAccountPassword", produces = APPLICATION_JSON_VALUE)
    public void updateAccountPassword(@RequestBody  ChangePasswordDTO newPassword) {
        accountService.updateAccountPassword(newPassword);
    }

    @RequestMapping(method = POST, path = "api/account/updateAccount", produces = APPLICATION_JSON_VALUE)
    public AccountDTO updateAccount(@RequestBody  AccountDTO accountDTO) {
        return accountService.updateAccount(accountDTO);
    }

    @RequestMapping(method = GET, path = "api/account/accountDetails", produces = APPLICATION_JSON_VALUE)
    public AccountDTO getAccountByEmail(@RequestParam(value="email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @RequestMapping(method = GET, path = "api/user/accounts", produces = APPLICATION_JSON_VALUE)
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(method = GET, path = "api/admin/accounts", produces = APPLICATION_JSON_VALUE)
    public List<AccountDTO> getAllAccounts2() {
        return accountService.getAllAccounts().subList(1, 2);
    }

    @RequestMapping(method = GET, path = "api/all/all", produces = APPLICATION_JSON_VALUE)
    public List<AccountDTO> getAllAccounts3() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(method = POST, path = "api/accounts", produces = APPLICATION_JSON_VALUE)
    public AccountDTO addAccount(@RequestBody AccountDTO account) {
        return accountService.addAccount(account);
    }


}
