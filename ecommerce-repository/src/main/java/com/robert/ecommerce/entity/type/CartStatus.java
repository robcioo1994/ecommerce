package com.robert.ecommerce.entity.type;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum CartStatus {

    NEW("New");

    private final String name;
    CartStatus(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
