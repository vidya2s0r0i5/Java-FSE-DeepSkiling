package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public String getLoanByNumber(@PathVariable String number) {
        return "Loan details for loan number: " + number;
    }
}
