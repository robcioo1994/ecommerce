package com.robert.ecommerce.rest;

import com.robert.ecommerce.config.security.TokenHandler;
import com.robert.ecommerce.service.impl.SecurityContextServiceImpl;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("/api/auth")
public class UserAuthRestController {

    private final AuthenticationManager authenticationManager;
    private final TokenHandler tokenHandler;
    private final SecurityContextServiceImpl securityContextService;

    @Autowired
    UserAuthRestController(AuthenticationManager authenticationManager,
                   TokenHandler tokenHandler, SecurityContextServiceImpl securityContextService) {
        this.authenticationManager = authenticationManager;
        this.tokenHandler = tokenHandler;
        this.securityContextService = securityContextService;
    }


    @RequestMapping(method = POST)
    public AuthResponse auth(@RequestBody AuthParams params) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return securityContextService.currentUser().map(u -> {
            final String token = tokenHandler.createTokenForUser(u);
            return new AuthResponse(token);
        }).orElseThrow(RuntimeException::new); // it does not happen.
    }

    @Value
    private static final class AuthParams {
        private final String identifier;
        private final String password;

        UsernamePasswordAuthenticationToken toAuthenticationToken() {
            return new UsernamePasswordAuthenticationToken(identifier, password);
        }
    }

    @Value
    private static final class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }
}
