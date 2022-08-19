package com.example.simplecalculator.calculator;

import com.example.simplecalculator.IntegrationTestClass;
import com.example.simplecalculator.entities.result.Result;
import com.example.simplecalculator.exceptions.CalculationNotValid;
import com.example.simplecalculator.services.calculation.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests extends IntegrationTestClass {
    @Autowired
    private CalculationService calculationService;

    @Test
    public void testAddCalculation() {
        Result result = calculationService.calculateCalculation("5+10");
        assertEquals(result.getResult(), 15);
    }

    @Test
    public void testSubstractCalculation() {
        Result result = calculationService.calculateCalculation("-5-10");
        assertEquals(result.getResult(), -15);
    }

    @Test
    public void testDivideCalculation() {
        Result result = calculationService.calculateCalculation("20/2");
        assertEquals(result.getResult(), 10);
    }

    @Test
    public void testMultiplyCalculation() {
        Result result = calculationService.calculateCalculation("5*5");
        assertEquals(result.getResult(), 25);
    }

    @Test
    public void testIncorrectCalculation() {
        assertThrows(CalculationNotValid.class, () -> calculationService.calculateCalculation("5-+10/5"));
    }
}
