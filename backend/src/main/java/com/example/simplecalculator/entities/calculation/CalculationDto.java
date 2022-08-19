package com.example.simplecalculator.entities.calculation;

import com.example.simplecalculator.entities.result.ResultDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalculationDto {
    private UUID id;

    private String calculation;

    private ResultDto resultDto;
}
