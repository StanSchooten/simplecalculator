package com.example.simplecalculator.entities.calculation;

import com.example.simplecalculator.entities.result.Result;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String calculation;

    @OneToOne
    private Result result;
}
