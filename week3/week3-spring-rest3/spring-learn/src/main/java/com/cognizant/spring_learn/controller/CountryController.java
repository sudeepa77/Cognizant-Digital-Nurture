package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    public CountryController(CountryService countryService) {

        this.countryService = countryService;

        LOGGER.debug("Inside CountryController Constructor");
    }

    @GetMapping("/country")
    public Country getCountryIndia() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("in", Country.class);

        LOGGER.debug("Country : {}", country);

        LOGGER.info("END");

        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                context.getBean("countryList", List.class);

        LOGGER.debug("Countries : {}", countries);

        LOGGER.info("END");

        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        LOGGER.info("START");

        Country country =
                countryService.getCountry(code);

        LOGGER.debug("Country : {}", country);

        LOGGER.info("END");

        return country;
    }
}