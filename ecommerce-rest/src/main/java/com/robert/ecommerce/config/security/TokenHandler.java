package com.robert.ecommerce.config.security;

import com.robert.ecommerce.dto.UserAuth;
import com.robert.ecommerce.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenHandler {

    private final String secret;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public TokenHandler(@Value("${ecommerce.jwt.secret}") String secret) {
        this.secret = secret;
    }

    public Optional<UserAuth> parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        UserAuth user = userDetailsService.loadUserByUsername(username);
        System.out.println("parseUserFromToken" + user.toString());
        return Optional.ofNullable(user);
    }

    public String createTokenForUser(UserAuth user){
        final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
//                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
    }
}