package com.example.simplecalculator.entities.result;

import com.example.simplecalculator.entities.calculation.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResultRepository extends JpaRepository<Result, UUID> {
    Result findResultByCalculation(Calculation calculation);
}
