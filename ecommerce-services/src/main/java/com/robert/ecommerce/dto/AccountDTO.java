package com.robert.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.robert.ecommerce.entity.type.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    private String email;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean credentialsNonExpired;

    private boolean accountNonLocked;

    private Set<UserRole> roles;
}