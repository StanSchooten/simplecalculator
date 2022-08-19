package com.example.simplecalculator.entities.result;

import com.example.simplecalculator.entities.calculation.Calculation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double result;

    @OneToOne
    private Calculation calculation;
}
