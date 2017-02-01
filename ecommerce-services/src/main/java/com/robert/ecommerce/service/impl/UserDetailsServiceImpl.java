package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.UserAuth;
import com.robert.ecommerce.entity.AccountEntity;
import com.robert.ecommerce.entity.type.UserRole;
import com.robert.ecommerce.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    public UserAuth loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<AccountEntity> accountEntity = accountRepository.findByUsername(userName);

        if (!accountEntity.isPresent() || accountEntity.get().getRoles().isEmpty()) {
            throw new UsernameNotFoundException("No such user: " + userName + "or user has no authorities");
        }
        else {
            final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

            UserAuth userAuth = new UserAuth(
                    accountEntity.get().getId(),
                    accountEntity.get().getFirstName(),
                    accountEntity.get().getLastName(),
                    accountEntity.get().getUsername(),
                    accountEntity.get().getPassword(),
                    accountEntity.get().getEmail(),
                    accountEntity.get().isEnabled(),
                    accountEntity.get().isAccountNonExpired(),
                    accountEntity.get().isCredentialsNonExpired(),
                    accountEntity.get().isAccountNonLocked(),
                    getAuthorities(accountEntity.get().getRoles())
            );
            detailsChecker.check(userAuth);
            return userAuth;
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<UserRole> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.toString().toUpperCase())).collect(Collectors.toList());
    }
}

