package com.robert.ecommerce.config;

import com.robert.ecommerce.config.filters.StatelessAuthenticationFilter;
import com.robert.ecommerce.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private StatelessAuthenticationFilter statelessAuthenticationFilter;

    public SecurityConfig() {
        super(true);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordencoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable();

        http
                .exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/styles/**", "/scripts/**", "/assets/**").permitAll()
                .antMatchers("/api/all/**").permitAll()

                // Allow anonymous logins
                .antMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
//                .antMatchers("/api/user/**").authenticated();//hasRole("CLIENT")
                .antMatchers("/api/account/**").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers("/api/user/**").hasRole("CLIENT")
                .antMatchers("/api/admin/**").hasRole("ADMIN");


        http
                // Custom Token based authentication based on the header previously given to the client
                .addFilterBefore(statelessAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
