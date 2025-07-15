package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.CountryModel;
import com.cognizant.spring_learn.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public CountryModel getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}
