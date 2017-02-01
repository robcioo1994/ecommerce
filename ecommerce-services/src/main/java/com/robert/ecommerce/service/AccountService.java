package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.AccountDTO;
import com.robert.ecommerce.dto.ChangePasswordDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO addAccount(AccountDTO account);

    AccountDTO findAccountByUsername(String username);

    AccountDTO updateAccountPassword(ChangePasswordDTO newPasswordSetting);

    AccountDTO updateAccount(AccountDTO accountDTO);

    AccountDTO getAccountByEmail(String email);

}
