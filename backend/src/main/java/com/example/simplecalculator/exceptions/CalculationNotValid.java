package com.example.simplecalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CalculationNotValid extends RuntimeException {

    public CalculationNotValid() {
        super("Calculation is not valid!");
    }

    public CalculationNotValid(String message) {
        super(message);
    }
}
