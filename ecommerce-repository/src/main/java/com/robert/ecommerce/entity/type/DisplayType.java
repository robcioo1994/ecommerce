package com.robert.ecommerce.entity.type;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum DisplayType {
    Mat("Mat"), BLINK("Blink");
    private final String name;

    private DisplayType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
