package com.M2Challenge.M2Challenge.controller;

import com.M2Challenge.M2Challenge.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
public class MonthController {

    List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1,"January"),
            new Month(2,"February"),
            new Month(3,"March"),
            new Month(4,"April"),
            new Month(5,"May"),
            new Month(6,"June"),
            new Month(7,"July"),
            new Month(8,"August"),
            new Month(9,"September"),
            new Month(10,"October"),
            new Month(11,"November"),
            new Month(12,"December")
    ));

    @GetMapping("/month/{number}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month generateMonthByNumber(@PathVariable @Valid int number){
        if(number < 1 || number > 12){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Input is out of range");
        }
        return months.get(number-1);
    }

    @GetMapping("/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month generateRandomMonth(){
        Random rand = new Random();
        int num = rand.nextInt(13);
        return months.get(num);
    }

}
