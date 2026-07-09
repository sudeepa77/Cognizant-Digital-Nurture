package com.cognizant.springlearn.controller;
import jakarta.validation.Valid;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {

        LOGGER.info("START");

        Country country = countryService.getCountry(code);

        LOGGER.info("END");

        return country;
    }

    @PostMapping
    public Country addCountry(
            @RequestBody @Valid Country country) {

        LOGGER.info("START");
        LOGGER.debug("Country : {}", country);
        LOGGER.info("END");

        return country;
    }
}