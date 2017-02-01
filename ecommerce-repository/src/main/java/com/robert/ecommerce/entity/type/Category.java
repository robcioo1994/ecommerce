package com.robert.ecommerce.entity.type;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum Category {
    GPU("GPU"), CPU("CPU");

    private final String name;

    private Category(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
