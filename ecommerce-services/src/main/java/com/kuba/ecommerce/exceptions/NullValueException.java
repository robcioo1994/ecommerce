package com.kuba.ecommerce.exceptions;

public class NullValueException extends Exception {

    private static final String message = "Value cannot be null!";

    public NullValueException() {
        super(message);
    }

}
