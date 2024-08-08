package com.gmail.lampbussinessextra.Classes.Error;

public class ConstructCoffeeError extends RuntimeException {
    public ConstructCoffeeError(String string) {
        super(string);
    }
}