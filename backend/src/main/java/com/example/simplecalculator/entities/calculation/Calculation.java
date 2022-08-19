package com.example.simplecalculator.entities.calculation;

import com.example.simplecalculator.entities.result.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String calculation;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private Result result;

    public Calculation(String calculation, Result result) {
        this.calculation = calculation;
        this.result = result;
    }
}
