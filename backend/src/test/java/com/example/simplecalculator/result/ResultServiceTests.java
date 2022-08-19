package com.example.simplecalculator.result;

import com.example.simplecalculator.entities.result.Result;
import com.example.simplecalculator.entities.result.ResultRepository;
import com.example.simplecalculator.services.result.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ResultServiceTests {
    private ResultService resultService;

    @Mock
    private ResultRepository resultRepository;

    List<Result> resultList;

    @BeforeEach
    public void init() {
        resultService = new ResultService(resultRepository);

        List<Result> temp = new ArrayList<>();
        temp.add(new Result());
        temp.add(new Result());
        temp.add(new Result());

        when(resultService.findAll()).thenReturn(temp);
        resultList = temp;
    }

    @Test
    public void findAllCalculations() {
        assertEquals(resultService.findAll(), resultList);
    }
}
