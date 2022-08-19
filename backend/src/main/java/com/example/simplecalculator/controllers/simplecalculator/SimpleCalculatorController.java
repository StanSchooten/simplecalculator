package com.example.simplecalculator.controllers.simplecalculator;

import com.example.simplecalculator.entities.calculation.Calculation;
import com.example.simplecalculator.entities.calculation.CalculationDto;
import com.example.simplecalculator.entities.result.Result;
import com.example.simplecalculator.entities.result.ResultDto;
import com.example.simplecalculator.services.calculation.CalculationService;
import com.example.simplecalculator.services.result.ResultService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class SimpleCalculatorController {
    private final CalculationService calculationService;
    private final ResultService resultService;

    public SimpleCalculatorController(CalculationService calculationService, ResultService resultService) {
        this.calculationService = calculationService;
        this.resultService = resultService;
    }

    @PostMapping()
    @Transactional
    public Result calculate(@RequestBody String calculation) {
        return calculationService.calculateCalculation(calculation);
    }

    @GetMapping()
    public List<CalculationDto> getCalculations() {
        resultService.findAll();
        return calculationsToDto(calculationService.getAllCalculations());
    }

    private List<CalculationDto> calculationsToDto(List<Calculation> calculationList) {
        List<CalculationDto> calculationDtos = new ArrayList<>();

        calculationList.forEach(i -> {
            ResultDto resultDto = new ResultDto(i.getResult().getId(), i.getResult().getResult());
            calculationDtos.add(new CalculationDto(i.getId(), i.getCalculation(), resultDto));
        });

        return calculationDtos;
    }
}
