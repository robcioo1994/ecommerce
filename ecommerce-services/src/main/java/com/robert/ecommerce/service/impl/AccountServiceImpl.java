package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.AccountDTO;
import com.robert.ecommerce.dto.ChangePasswordDTO;
import com.robert.ecommerce.entity.AccountEntity;
import com.robert.ecommerce.repository.AccountRepository;
import com.robert.ecommerce.service.AccountService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MapperFacade mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<AccountDTO> getAllAccounts() {
        return mapper.mapAsList(accountRepository.findAll(), AccountDTO.class);
    }

    @Override
    public AccountDTO addAccount(AccountDTO account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        AccountEntity accountEntityToAdd = mapper.map(account, AccountEntity.class);
        AccountEntity save = accountRepository.save(accountEntityToAdd);
        return mapper.map(save, AccountDTO.class);
    }

    @Override
    public AccountDTO findAccountByUsername(String username) {
        Optional<AccountEntity> accountEntity = accountRepository.findByUsername(username);
        return accountEntity.isPresent() ? mapper.map(accountEntity.get(), AccountDTO.class) : null;
    }

    @Override
    public AccountDTO updateAccountPassword(ChangePasswordDTO newPasswordSetting) {
        Optional<AccountEntity> accountEntity = accountRepository.findByEmail(newPasswordSetting.getEmail());
//        if (accountEntity.isPresent() && accountEntity.get().getPassword().equals(passwordEncoder.encode(newPasswordSetting.getOldPassword()))){
            accountEntity.get().setPassword(passwordEncoder.encode(newPasswordSetting.getNewPassword()));
            accountRepository.save(accountEntity.get());
//        }
        return null;
    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO) {
        Optional<AccountEntity> accountEntity = Optional.ofNullable(accountRepository.findOne(accountDTO.getId()));
        if(accountEntity.isPresent()){
            accountEntity.get().setEmail(accountDTO.getEmail());
            accountEntity.get().setFirstName(accountDTO.getFirstName());
            accountEntity.get().setLastName(accountDTO.getLastName());
            accountRepository.save(accountEntity.get());
            return mapper.map(accountEntity.get(), AccountDTO.class);
        }
        return mapper.map(accountEntity.get(), AccountDTO.class);
    }

    @Override
    public AccountDTO getAccountByEmail(String email) {
        Optional<AccountEntity> accountEntity = accountRepository.findByEmail(email);
        return accountEntity.isPresent() ? mapper.map(accountEntity.get(), AccountDTO.class) : null;
    }
}
