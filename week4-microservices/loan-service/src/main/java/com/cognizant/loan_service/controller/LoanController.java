package com.cognizant.loan_service.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoan(@PathVariable String number) {

        return Map.of(
                "number", number,
                "type", "Car",
                "loan", 400000,
                "emi", 3258,
                "tenure", 18
        );
    }
}