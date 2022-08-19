package com.example.simplecalculator.services.simplecalculator;

import org.springframework.stereotype.Service;

//normally would be called SimpleCalculatorService, but the assignment called for this name.
@Service
public class SimpleCalculator {

    public double add(int x, int y) {
        return x + y;
    }

    public double subtract(int x, int y) {
        return x - y;
    }

    public double multiply(int x, int y) {
        return x * y;
    }

    public double divide(int x, int y) {
        return (double) x / y;
    }
}
