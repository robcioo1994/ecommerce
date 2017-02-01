package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityContextServiceImpl {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public Optional<UserAuth> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(userDetailsService.loadUserByUsername(authentication.getName()));
    }
}
