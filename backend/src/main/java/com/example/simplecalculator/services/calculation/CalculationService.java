package com.example.simplecalculator.services.calculation;

import com.example.simplecalculator.entities.calculation.Calculation;
import com.example.simplecalculator.entities.calculation.CalculationRepository;
import com.example.simplecalculator.entities.result.Result;
import com.example.simplecalculator.entities.result.ResultRepository;
import com.example.simplecalculator.exceptions.CalculationNotValid;
import com.example.simplecalculator.services.simplecalculator.SimpleCalculator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculationService {

    private final SimpleCalculator simpleCalculator;
    private final CalculationRepository calculationRepository;
    private final ResultRepository resultRepository;
    private final EntityManager entityManager;


    public CalculationService(SimpleCalculator simpleCalculator, CalculationRepository calculationRepository, ResultRepository resultRepository, EntityManager entityManager) {
        this.simpleCalculator = simpleCalculator;
        this.calculationRepository = calculationRepository;
        this.resultRepository = resultRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public Result calculateCalculation(String calculation) {
        List<String> calculations = breakApartCalculation(calculation);
        double calculationResult = 0;

        if (calculations.size() == 3) {
            calculationResult = calculate(Integer.parseInt(calculations.get(0)), Integer.parseInt(calculations.get(2)), calculations.get(1));
        } else if (calculations.size() == 4 && calculations.get(0).equals("-")) {
            calculationResult = calculate(Integer.parseInt(calculations.get(1)) * -1, Integer.parseInt(calculations.get(3)), calculations.get(2));
        } else {
            throw new CalculationNotValid();
        }

        Result result = new Result(calculationResult);
        resultRepository.save(result);

        Calculation calculationObject = new Calculation(calculation, result);
        calculationRepository.save(calculationObject);

        return result;
    }

    private List<String> breakApartCalculation(String calculation) {
        return Arrays
                .stream(calculation.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)"))
                .collect(Collectors.toList());
    }

    private double calculate(int x, int y, String operator) {
        switch (operator) {
            case "-":
                return simpleCalculator.subtract(x, y);
            case "+":
                return simpleCalculator.add(x, y);
            case "/":
                return simpleCalculator.divide(x, y);
            case "*":
                return simpleCalculator.multiply(x, y);
            default:
                throw new CalculationNotValid();
        }
    }

    public List<Calculation> getAllCalculations() {
        return calculationRepository.findAll();
    }
}
