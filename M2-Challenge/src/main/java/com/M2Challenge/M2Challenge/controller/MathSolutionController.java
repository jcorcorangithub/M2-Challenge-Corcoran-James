package com.M2Challenge.M2Challenge.controller;

import com.M2Challenge.M2Challenge.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class MathSolutionController {

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution add(@Valid @RequestBody MathSolution input){
        if((input.getOperand1() == null || input.getOperand2() == null)){
            throw new IllegalArgumentException("you must supply a number for both operands");
        }
        return new MathSolution(input.getOperand1(), input.getOperand2(), "add", input.getOperand1()+input.getOperand2());
    }

    @PostMapping(value = "/subtract")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution subtract(@RequestBody @Valid MathSolution input) {
        if((input.getOperand1() == null || input.getOperand2() == null)){
            throw new IllegalArgumentException("you must supply a number for both operands");
        }

        return new MathSolution(input.getOperand1(), input.getOperand2(), "subtract", input.getOperand1() - input.getOperand2());
    }

    @PostMapping(value = "/multiply")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution multiply(@RequestBody @Valid MathSolution input){
        if((input.getOperand1() == null || input.getOperand2() == null)){
            throw new IllegalArgumentException("you must supply a number for both operands");
        }

        return new MathSolution(input.getOperand1(), input.getOperand2(), "multiply", input.getOperand1() * input.getOperand2());
    }

    @PostMapping(value = "/divide")
    @ResponseStatus(value = HttpStatus.OK)
    public MathSolution divide(@RequestBody @Valid MathSolution input){
        if((input.getOperand1() == null || input.getOperand2() == null) || input.getOperand2() == 0){
            throw new IllegalArgumentException("you must supply a number for both operands and operand2 cannot be a zero");
        }

        return new MathSolution(input.getOperand1(), input.getOperand2(), "divide", input.getOperand1() / input.getOperand2());
    }
}
