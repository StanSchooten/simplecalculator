package com.example.simplecalculator.calculator;

import com.example.simplecalculator.entities.calculation.Calculation;
import com.example.simplecalculator.entities.calculation.CalculationRepository;
import com.example.simplecalculator.entities.result.ResultRepository;
import com.example.simplecalculator.services.calculation.CalculationService;
import com.example.simplecalculator.services.simplecalculator.SimpleCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculationServiceTests {

    private CalculationService calculationService;

    @Mock
    private CalculationRepository calculationRepository;
    @Mock
    private ResultRepository resultRepository;
    @Mock
    private SimpleCalculator simpleCalculator;
    @Mock
    private EntityManager entityManager;

    List<Calculation> calculationList;

    @BeforeEach
    public void init() {
        calculationService = new CalculationService(simpleCalculator, calculationRepository, resultRepository, entityManager);

        List<Calculation> temp = new ArrayList<>();
        temp.add(new Calculation());
        temp.add(new Calculation());
        temp.add(new Calculation());

        when(calculationRepository.findAll()).thenReturn(temp);
        calculationList = temp;
    }

    @Test
    public void findAllCalculations() {
        assertEquals(calculationService.getAllCalculations(), calculationList);
    }
}
