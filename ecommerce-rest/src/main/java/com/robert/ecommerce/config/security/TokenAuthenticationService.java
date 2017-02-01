package com.robert.ecommerce.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    private final TokenHandler tokenHandler;

    @Autowired
    public TokenAuthenticationService(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

//    public void addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
//        final User user = authentication.getDetails();
//        response.addHeader(AUTH_HEADER_NAME, tokenHandler.createTokenForUser(user));
//    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null)
            return tokenHandler.parseUserFromToken(token).map(UserAuthentication::new).orElse(null);
        else
            return null;
    }
}
