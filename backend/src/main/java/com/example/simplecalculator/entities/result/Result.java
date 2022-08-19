package com.example.simplecalculator.entities.result;

import com.example.simplecalculator.entities.calculation.Calculation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private double result;

    @OneToOne(mappedBy = "result")
    private Calculation calculation;

    public Result(double result) {
        this.result = result;
    }
}
