package com.example.simplecalculator.services.result;

import com.example.simplecalculator.entities.calculation.Calculation;
import com.example.simplecalculator.entities.result.Result;
import com.example.simplecalculator.entities.result.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Result findResultByCalculation(Calculation calculation) {
        return resultRepository.findResultByCalculation(calculation);
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }
}
