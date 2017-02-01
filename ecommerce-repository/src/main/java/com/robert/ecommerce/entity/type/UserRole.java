package com.robert.ecommerce.entity.type;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum UserRole {
    CLIENT("Client"), ADMIN("Admin");
    private final String name;

    private UserRole(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
